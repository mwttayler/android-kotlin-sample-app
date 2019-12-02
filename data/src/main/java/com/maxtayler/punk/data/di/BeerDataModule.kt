package com.maxtayler.punk.data.di

import com.maxtayler.punk.data.datastore.BeerDataStore
import com.maxtayler.punk.data.datastore.local.BeerLocalDataStore
import com.maxtayler.punk.data.datastore.remote.BeerRemoteDataStore
import com.maxtayler.punk.data.repository.BeerRepositoryImpl
import com.maxtayler.punk.domain.repository.BeerRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [DatabaseModule::class, RetrofitModule::class])
abstract class BeerDataModule {

    @Binds
    @Singleton
    internal abstract fun bindRepository(impl: BeerRepositoryImpl): BeerRepository

    @Binds
    @Singleton
    internal abstract fun bindLocal(impl: BeerLocalDataStore): BeerDataStore.Local

    @Binds
    @Singleton
    internal abstract fun bindRemote(impl: BeerRemoteDataStore): BeerDataStore.Remote
}