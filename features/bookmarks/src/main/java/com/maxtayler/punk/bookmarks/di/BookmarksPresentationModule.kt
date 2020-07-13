package com.maxtayler.punk.bookmarks.di

import androidx.lifecycle.ViewModel
import com.maxtayler.punk.bookmarks.BookmarksViewModel
import com.maxtayler.punk.data.di.BeerDataModule
import com.maxtayler.punk.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories
import dagger.multibindings.IntoMap

@Module(includes = [BeerDataModule::class])
@InstallIn(FragmentComponent::class)
internal abstract class BookmarksPresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(BookmarksViewModel::class)
    abstract fun bindViewModel(vm: BookmarksViewModel): ViewModel
}
