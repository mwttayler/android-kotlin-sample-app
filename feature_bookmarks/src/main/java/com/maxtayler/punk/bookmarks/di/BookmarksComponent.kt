package com.maxtayler.punk.bookmarks.di

import com.maxtayler.punk.base.BaseComponent
import com.maxtayler.punk.bookmarks.BookmarksFragment
import com.maxtayler.punk.di.SingletonComponent
import com.maxtayler.punk.di.scope.FragmentScope
import dagger.Component

@FragmentScope
@Component(
    modules = [BookmarksPresentationModule::class],
    dependencies = [SingletonComponent::class]
)
interface BookmarksComponent : BaseComponent<BookmarksFragment> {

    @Component.Factory
    interface Factory {

        fun create(component: SingletonComponent): BookmarksComponent
    }
}