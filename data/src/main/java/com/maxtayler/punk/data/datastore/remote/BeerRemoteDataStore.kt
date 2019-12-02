package com.maxtayler.punk.data.datastore.remote

import com.maxtayler.punk.data.datastore.BeerDataStore
import com.maxtayler.punk.data.network.model.BeerResponse
import com.maxtayler.punk.data.network.service.PunkApiService
import javax.inject.Inject

internal class BeerRemoteDataStore @Inject constructor(
    private val apiService: PunkApiService
) : BeerDataStore.Remote {

    override suspend fun getBeer(id: Long): BeerResponse {
        return apiService.getBeer(id).first()
    }

    override suspend fun getBeers(): List<BeerResponse> {
        return apiService.getBeers()
    }
}