package com.maxtayler.punk.latest.di

import com.maxtayler.punk.base.BaseComponent
import com.maxtayler.punk.di.SingletonComponent
import com.maxtayler.punk.di.scope.FragmentScope
import com.maxtayler.punk.latest.LatestFragment
import dagger.Component

@FragmentScope
@Component(
    modules = [LatestPresentationModule::class],
    dependencies = [SingletonComponent::class]
)
interface LatestComponent : BaseComponent<LatestFragment> {

    @Component.Factory
    interface Factory {

        fun create(component: SingletonComponent): LatestComponent
    }
}
