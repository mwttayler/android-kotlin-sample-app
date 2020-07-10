package com.maxtayler.punk.data.datastore.local

import com.maxtayler.punk.data.datastore.BeerDataStore
import com.maxtayler.punk.domain.entity.BeerEntity
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

internal class BeerLocalDataStore @Inject constructor(
    private val database: BeerDatabase
) : BeerDataStore.Local {

    override suspend fun getBookmarks(): Flow<List<BeerEntity>> {
        return database.bookmarksDao().getAll()
    }

    override suspend fun insertBookmark(beer: BeerEntity) {
        database.bookmarksDao().insert(beer.copy(isBookmarked = true))
    }

    override suspend fun removeBookmark(beer: BeerEntity) {
        database.bookmarksDao().remove(beer)
    }
}
