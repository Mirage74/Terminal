package com.balex.terminal.domain.usecases

import com.balex.terminal.domain.entity.TimeFrame
import com.balex.terminal.domain.repository.TerminalRepository
import javax.inject.Inject

class RefreshQuotesUseCase @Inject constructor(
    private val repository: TerminalRepository
) {

    operator fun invoke(timeFrame: TimeFrame) {
        return repository.refreshQuotes(timeFrame)
    }
}