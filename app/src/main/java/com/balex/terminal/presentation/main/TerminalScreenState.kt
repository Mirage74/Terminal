package com.balex.terminal.presentation.main


import com.balex.terminal.domain.entity.Bar

sealed class TerminalScreenState {

    data object Initial : TerminalScreenState()

    data object Loading : TerminalScreenState()

    data class Content(val barList: List<Bar>) : TerminalScreenState()
}