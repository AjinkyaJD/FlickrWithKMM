package com.ajinkyad.flickrelectrolux.android.application

import android.app.Application
import com.ajinkyad.flickrelectrolux.android.di.androidModule
import com.ajinkyad.flickrelectrolux.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(appModule() + androidModule)
        }
    }
}