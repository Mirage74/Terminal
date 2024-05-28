package com.balex.terminal.presentation.main

import androidx.lifecycle.ViewModel
import com.balex.terminal.domain.usecases.GetQuotesUseCase
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class TerminalViewModel @Inject constructor(
    getQuotesUseCase: GetQuotesUseCase
): ViewModel() {

    private val quotesFlow = getQuotesUseCase()



    val state = quotesFlow
        .filter { it.isNotEmpty() }
        .map { TerminalScreenState.Content(barList = it) as TerminalScreenState }
        .onStart { emit(TerminalScreenState.Loading) }


}