package com.yunusbedir.weatherapp.di

import com.yunusbedir.weatherapp.data.remote.OpenWeatherMapService
import com.yunusbedir.weatherapp.data.remote.repository.OpenWeatherMapRepositoryImpl
import com.yunusbedir.weatherapp.domain.repository.OpenWeatherMapRepository
import com.yunusbedir.weatherapp.domain.usecase.GetCurrentWeatherUseCase
import com.yunusbedir.weatherapp.util.provideDispatcher
import org.koin.dsl.module


private val dataModule = module {
    factory { OpenWeatherMapService() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<OpenWeatherMapRepository> { OpenWeatherMapRepositoryImpl(get(), get()) }
    factory { GetCurrentWeatherUseCase() }
}

private val sharedModules = listOf(
    dataModule, utilityModule, domainModule
)

fun getSharedModules() = sharedModules