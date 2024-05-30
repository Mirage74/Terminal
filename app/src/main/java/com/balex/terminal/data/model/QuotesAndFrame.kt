package com.balex.terminal.data.model

import com.balex.terminal.domain.entity.Bar
import com.balex.terminal.domain.entity.TimeFrame
import java.util.Collections

data class QuotesAndFrame (
    val barList: List<Bar> = Collections.emptyList(),
    val timeFrame: TimeFrame = TimeFrame.HOUR_1,
    val isLoading: Boolean = false
)