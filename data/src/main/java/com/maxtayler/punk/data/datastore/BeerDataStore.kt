package com.maxtayler.punk.data.datastore

import com.maxtayler.punk.data.network.model.BeerResponse
import com.maxtayler.punk.domain.entity.BeerEntity
import kotlinx.coroutines.flow.Flow

internal interface BeerDataStore {

    interface Local {

        suspend fun getBookmarks(): Flow<List<BeerEntity>>

        suspend fun insertBookmark(beer: BeerEntity)

        suspend fun removeBookmark(beer: BeerEntity)
    }

    interface Remote {

        suspend fun getBeer(id: Long): BeerResponse

        suspend fun getBeers(): List<BeerResponse>
    }
}