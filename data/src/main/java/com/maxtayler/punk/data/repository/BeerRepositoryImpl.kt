package com.maxtayler.punk.data.repository

import com.maxtayler.punk.data.datastore.BeerDataStore
import com.maxtayler.punk.data.mapper.BeerEntityMapper
import com.maxtayler.punk.domain.entity.BeerEntity
import com.maxtayler.punk.domain.repository.BeerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class BeerRepositoryImpl @Inject constructor(
    private val local: BeerDataStore.Local,
    private val remote: BeerDataStore.Remote,
    private val mapper: BeerEntityMapper
) : BeerRepository {

    override suspend fun getBeer(id: Long): Flow<BeerEntity> {
        return local.getBookmarks().map { bookmarks ->
            remote.getBeer(id).let {
                mapper.mapFrom(BeerEntityMapper.Params(it, bookmarks))
            }
        }
    }

    override suspend fun getBeers(): Flow<List<BeerEntity>> {
        val beers = remote.getBeers()
        return local.getBookmarks().map { bookmarks ->
            beers.map { beer ->
                mapper.mapFrom(BeerEntityMapper.Params(beer, bookmarks))
            }
        }
    }

    override suspend fun getBookmarks(): Flow<List<BeerEntity>> {
        return local.getBookmarks()
    }

    override suspend fun insertBookmark(beer: BeerEntity) {
        local.insertBookmark(beer)
    }

    override suspend fun removeBookmark(beer: BeerEntity) {
        local.removeBookmark(beer)
    }
}