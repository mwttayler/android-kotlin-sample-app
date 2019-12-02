package com.maxtayler.punk

import android.app.Application
import android.content.Context
import com.maxtayler.punk.di.DaggerSingletonComponent
import com.maxtayler.punk.di.SingletonComponent
import timber.log.Timber

class PunkApplication : Application() {

    private val singletonComponent: SingletonComponent by lazy { DaggerSingletonComponent.factory().create(this) }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    companion object {

        val Context.singletonComponent
            get() = (applicationContext as PunkApplication).singletonComponent
    }
}