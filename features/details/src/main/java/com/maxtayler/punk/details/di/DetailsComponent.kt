package com.maxtayler.punk.details.di

import com.maxtayler.punk.base.BaseComponent
import com.maxtayler.punk.details.DetailsFragment
import com.maxtayler.punk.di.SingletonComponent
import com.maxtayler.punk.di.scope.FragmentScope
import dagger.Component

@FragmentScope
@Component(
    modules = [DetailsPresentationModule::class],
    dependencies = [SingletonComponent::class]
)
interface DetailsComponent : BaseComponent<DetailsFragment> {

    @Component.Factory
    interface Factory {

        fun create(component: SingletonComponent): DetailsComponent
    }
}
