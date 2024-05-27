package com.balex.terminal.presentation

import com.balex.terminal.data.Bar

sealed class TerminalScreenState {

    data object Initial : TerminalScreenState()

    data class Content(val barList: List<Bar>) : TerminalScreenState()
}