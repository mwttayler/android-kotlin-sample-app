package com.maxtayler.core

import android.app.Application
import android.content.Context
import com.maxtayler.core.di.CoreComponent
import com.maxtayler.core.di.DaggerCoreComponent
import timber.log.Timber

class CoreApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    companion object {

        val Context.singletonComponent
            get() = (applicationContext as CoreApplication).coreComponent
    }
}
