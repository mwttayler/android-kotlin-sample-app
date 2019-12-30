package com.maxtayler.punk.latest.di

import com.maxtayler.core.base.BaseComponent
import com.maxtayler.core.di.CoreComponent
import com.maxtayler.core.di.scope.FragmentScope
import com.maxtayler.punk.latest.LatestFragment
import dagger.Component

@FragmentScope
@Component(
    modules = [LatestPresentationModule::class],
    dependencies = [CoreComponent::class]
)
interface LatestComponent : BaseComponent<LatestFragment> {

    @Component.Factory
    interface Factory {

        fun create(component: CoreComponent): LatestComponent
    }
}
