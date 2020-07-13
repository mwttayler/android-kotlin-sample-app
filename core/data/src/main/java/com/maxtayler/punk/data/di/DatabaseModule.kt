package com.maxtayler.punk.data.di

import android.content.Context
import androidx.room.Room
import com.maxtayler.punk.data.datastore.local.BeerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Singleton

@Module
@InstallIn(FragmentComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    internal fun provideDatabase(context: Context): BeerDatabase {
        return BeerDatabase::class.java.let {
            Room.databaseBuilder(context, it, it.simpleName).build()
        }
    }
}
