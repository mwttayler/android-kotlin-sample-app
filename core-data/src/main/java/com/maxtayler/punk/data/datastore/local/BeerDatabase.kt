package com.maxtayler.punk.data.datastore.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.maxtayler.punk.domain.entity.BeerEntity

@Database(
    entities = [BeerEntity::class],
    version = 1
)
internal abstract class BeerDatabase : RoomDatabase() {

    abstract fun bookmarksDao(): BookmarksDao
}
