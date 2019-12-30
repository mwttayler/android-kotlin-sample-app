package com.maxtayler.punk.details.di

import androidx.lifecycle.ViewModel
import com.maxtayler.punk.details.DetailsViewModel
import com.maxtayler.core.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DetailsPresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindViewModel(vm: DetailsViewModel): ViewModel
}
