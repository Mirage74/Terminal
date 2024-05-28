package com.balex.terminal.domain.entity

import androidx.compose.runtime.Immutable
import java.util.Calendar


@Immutable
data class Bar(
    val open: Float,
    val close: Float,
    val low: Float,
    val high: Float,
    val calendar: Calendar
)