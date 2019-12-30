package com.maxtayler.punk.data.datastore.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maxtayler.punk.domain.entity.BeerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarksDao {

    @Query("SELECT * FROM BeerEntity")
    fun getAll(): Flow<List<BeerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(beer: BeerEntity)

    @Delete
    suspend fun remove(beer: BeerEntity)
}
