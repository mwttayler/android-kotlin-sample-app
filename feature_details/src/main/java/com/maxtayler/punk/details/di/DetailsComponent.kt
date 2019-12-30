package com.maxtayler.punk.details.di

import com.maxtayler.core.base.BaseComponent
import com.maxtayler.punk.details.DetailsFragment
import com.maxtayler.core.di.CoreComponent
import com.maxtayler.core.di.scope.FragmentScope
import dagger.Component

@FragmentScope
@Component(
    modules = [DetailsPresentationModule::class],
    dependencies = [CoreComponent::class]
)
interface DetailsComponent : BaseComponent<DetailsFragment> {

    @Component.Factory
    interface Factory {

        fun create(component: CoreComponent): DetailsComponent
    }
}
