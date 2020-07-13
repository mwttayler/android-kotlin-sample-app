package com.maxtayler.punk.latest.di

import androidx.lifecycle.ViewModel
import com.maxtayler.punk.data.di.BeerDataModule
import com.maxtayler.punk.di.viewmodel.ViewModelKey
import com.maxtayler.punk.latest.LatestViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories
import dagger.multibindings.IntoMap

@Module(includes = [BeerDataModule::class])
@InstallIn(FragmentComponent::class)
internal abstract class LatestPresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(LatestViewModel::class)
    abstract fun bindViewModel(vm: LatestViewModel): ViewModel
}
