package com.balex.terminal.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.balex.terminal.data.network.ApiFactory
import com.balex.terminal.domain.usecases.GetQuotesUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class TerminalViewModel @Inject constructor(
    getQuotesUseCase: GetQuotesUseCase
): ViewModel() {

    private val quotesFlow = getQuotesUseCase()



    val state = quotesFlow
        .filter { it.isNotEmpty() }
        .map { TerminalScreenState.Content(barList = it) as TerminalScreenState }
        .onStart { emit(TerminalScreenState.Loading) }




    init {
        loadBarList()
    }

    private fun loadBarList() {
//        viewModelScope.launch(exceptionHandler) {
//            val barList = apiService.loadBars().barList
//            _state.value = TerminalScreenState.Content(barList = barList)
  //      }
    }
}