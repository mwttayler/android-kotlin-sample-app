package com.maxtayler.punk.latest.di

import androidx.lifecycle.ViewModel
import com.maxtayler.punk.di.viewmodel.ViewModelKey
import com.maxtayler.punk.latest.LatestViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LatestPresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(LatestViewModel::class)
    abstract fun bindViewModel(vm: LatestViewModel): ViewModel
}
