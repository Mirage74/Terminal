package com.balex.terminal.data.network

import com.balex.terminal.data.model.ResultDto
import retrofit2.http.GET

interface ApiService {

    @GET("aggs/ticker/AAPL/range/1/hour/2022-01-09/2023-01-09?adjusted=true&sort=asc&limit=50000&apiKey=ssVve8W0pzLJm1a0uVMt1jspmPhw69L8")
    suspend fun loadBars(): ResultDto
}