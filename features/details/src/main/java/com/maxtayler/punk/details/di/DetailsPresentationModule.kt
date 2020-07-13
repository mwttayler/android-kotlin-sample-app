package com.maxtayler.punk.details.di

import androidx.lifecycle.ViewModel
import com.maxtayler.punk.data.di.BeerDataModule
import com.maxtayler.punk.details.DetailsViewModel
import com.maxtayler.punk.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories
import dagger.multibindings.IntoMap

@Module(includes = [BeerDataModule::class])
@InstallIn(FragmentComponent::class)
abstract class DetailsPresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindViewModel(vm: DetailsViewModel): ViewModel
}
