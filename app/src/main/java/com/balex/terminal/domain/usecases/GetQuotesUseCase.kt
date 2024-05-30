package com.balex.terminal.domain.usecases


import com.balex.terminal.data.model.QuotesAndFrame
import com.balex.terminal.domain.entity.TimeFrame
import com.balex.terminal.domain.repository.TerminalRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: TerminalRepository
) {

    operator fun invoke(): StateFlow<QuotesAndFrame> {
        return repository.getQuotes()
    }
}