package com.balex.terminal.domain.usecases


import com.balex.terminal.domain.entity.Bar
import com.balex.terminal.domain.repository.TerminalRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: TerminalRepository
) {

    operator fun invoke(): StateFlow<List<Bar>> {
        return repository.getQuotes()
    }
}