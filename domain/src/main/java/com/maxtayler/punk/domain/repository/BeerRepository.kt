package com.maxtayler.punk.domain.repository

import com.maxtayler.punk.domain.entity.BeerEntity
import kotlinx.coroutines.flow.Flow

interface BeerRepository {

    suspend fun getBeer(id: Long): Flow<BeerEntity>

    suspend fun getBeers(): Flow<List<BeerEntity>>

    suspend fun getBookmarks(): Flow<List<BeerEntity>>

    suspend fun insertBookmark(beer: BeerEntity)

    suspend fun removeBookmark(beer: BeerEntity)
}
