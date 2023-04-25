package com.yunusbedir.weatherapp.util

import com.yunusbedir.weatherapp.di.getSharedModules
import org.koin.core.context.startKoin


fun initKoin() {
    startKoin {
        modules(getSharedModules())
    }
}