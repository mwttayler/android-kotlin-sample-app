package com.maxtayler.punk.bookmarks.di

import com.maxtayler.core.base.BaseComponent
import com.maxtayler.punk.bookmarks.BookmarksFragment
import com.maxtayler.core.di.CoreComponent
import com.maxtayler.core.di.scope.FragmentScope
import dagger.Component

@FragmentScope
@Component(
    modules = [BookmarksPresentationModule::class],
    dependencies = [CoreComponent::class]
)
interface BookmarksComponent : BaseComponent<BookmarksFragment> {

    @Component.Factory
    interface Factory {

        fun create(component: CoreComponent): BookmarksComponent
    }
}
