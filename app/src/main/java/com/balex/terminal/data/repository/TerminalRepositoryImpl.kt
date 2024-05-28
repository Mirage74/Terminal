package com.balex.terminal.data.repository

import android.util.Log
import com.balex.terminal.data.mapper.QuotesMapper
import com.balex.terminal.data.network.ApiFactory
import com.balex.terminal.data.network.ApiService
import com.balex.terminal.domain.entity.Bar
import com.balex.terminal.domain.repository.TerminalRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


class TerminalRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: QuotesMapper
): TerminalRepository {

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.d("TerminalRepositoryImpl", "Exception caught: $throwable")
    }
    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    private val _quotesList = mutableListOf<Bar>()
    private val quotesList: List<Bar>
        get() = _quotesList.toList()

    private val isQuotesListNeedRefreshFlow = MutableSharedFlow<Unit>(replay = 1)


    override fun getQuotes(): StateFlow<List<Bar>> = flow {
        coroutineScope.launch (exceptionHandler) {
            _quotesList.addAll(mapper.mapResponseToQuotes(apiService.loadBars().barList))
            isQuotesListNeedRefreshFlow.emit(Unit)
        }
        isQuotesListNeedRefreshFlow.collect {
            emit(quotesList)
        }
    }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.Lazily,
            initialValue = quotesList
        )
}