package com.maxtayler.punk.bookmarks.di

import androidx.lifecycle.ViewModel
import com.maxtayler.punk.bookmarks.BookmarksViewModel
import com.maxtayler.punk.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class BookmarksPresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(BookmarksViewModel::class)
    abstract fun bindViewModel(vm: BookmarksViewModel): ViewModel
}
