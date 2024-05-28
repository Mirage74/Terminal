package com.balex.terminal.data.model

import com.google.gson.annotations.SerializedName

data class ResultDto(
    @SerializedName("results") val barList: List<BarDto>
)