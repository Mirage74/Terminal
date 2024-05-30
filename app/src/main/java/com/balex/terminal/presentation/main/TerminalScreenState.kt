package com.balex.terminal.presentation.main


import com.balex.terminal.domain.entity.Bar
import com.balex.terminal.domain.entity.TimeFrame

sealed class TerminalScreenState {

    data object Initial : TerminalScreenState()

    data object Loading : TerminalScreenState()

    data object Error : TerminalScreenState()

    data class Content(val barList: List<Bar>, val timeFrame: TimeFrame) : TerminalScreenState()
}