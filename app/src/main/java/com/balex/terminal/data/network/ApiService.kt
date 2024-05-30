package com.balex.terminal.data.network

import com.balex.terminal.data.model.ResultDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    @GET("aggs/ticker/{code}/range/{timeframe}/{dateFrom}/{dateTo}?adjusted=true")
    suspend fun loadBars(
        @Path("code") asset_code: String = ASSET_CODE,
        @Path("timeframe") timeFrame: String = TIME_FRAME,
        @Path("dateFrom") dateFrom: String = DATE_FROM,
        @Path("dateTo") dateTo: String = DATE_TO,
        @Query("sort") sort: String = SORT,
        @Query("limit") limit: Int = LIMIT,
        @Query("apiKey") apiToken: String = API_TOKEN
    ): ResultDto

    companion object {
        const val ASSET_CODE = "AAPL"
        //const val ASSET_CODE = "TSLA"
        //const val ASSET_CODE = "C:EURUSD"
        const val TIME_FRAME = "1/hour"
        const val DATE_FROM = "2022-01-09"
        const val DATE_TO = "2023-01-09"
        //const val SORT = "asc"
        const val SORT = "desc"
        const val LIMIT = 50000
        const val API_TOKEN = "ssVve8W0pzLJm1a0uVMt1jspmPhw69L8"
    }
}