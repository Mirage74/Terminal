package com.balex.terminal.domain.repository

import com.balex.terminal.domain.entity.Bar
import kotlinx.coroutines.flow.StateFlow

interface TerminalRepository {
    fun getQuotes(): StateFlow<List<Bar>>
}