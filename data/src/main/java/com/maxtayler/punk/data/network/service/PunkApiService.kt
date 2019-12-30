package com.maxtayler.punk.data.network.service

import com.maxtayler.punk.data.network.model.BeerResponse
import retrofit2.http.GET
import retrofit2.http.Path

internal interface PunkApiService {

    @GET("beers/{id}")
    suspend fun getBeer(@Path("id") id: Long): List<BeerResponse>

    @GET("beers")
    suspend fun getBeers(): List<BeerResponse>
}
