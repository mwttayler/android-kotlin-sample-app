package com.maxtayler.punk.data.di

import android.content.Context
import androidx.room.Room
import com.maxtayler.punk.data.datastore.local.BeerDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    internal fun provideDatabase(context: Context): BeerDatabase {
        return BeerDatabase::class.java.let {
            Room.databaseBuilder(context, it, it.simpleName).build()
        }
    }
}