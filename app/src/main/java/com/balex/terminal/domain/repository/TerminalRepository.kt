package com.balex.terminal.domain.repository

import com.balex.terminal.data.model.QuotesAndFrame
import com.balex.terminal.domain.entity.TimeFrame
import kotlinx.coroutines.flow.StateFlow

interface TerminalRepository {
    fun getQuotes(): StateFlow<QuotesAndFrame>

    fun refreshQuotes(timeFrame: TimeFrame)
}