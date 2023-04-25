package com.yunusbedir.weatherapp.android

import android.app.Application
import com.yunusbedir.weatherapp.android.di.appModule
import com.yunusbedir.weatherapp.di.getSharedModules
import org.koin.core.context.startKoin

class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}