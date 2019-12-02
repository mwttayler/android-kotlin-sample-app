package com.maxtayler.punk.di

import android.content.Context
import com.maxtayler.punk.data.di.BeerDataModule
import com.maxtayler.punk.domain.repository.BeerRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        BeerDataModule::class
    ]
)
interface SingletonComponent {

    fun exposeBeerRepository(): BeerRepository

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context): SingletonComponent
    }
}