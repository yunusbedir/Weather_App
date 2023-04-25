package com.yunusbedir.weatherapp.data.remote.repository

import com.yunusbedir.weatherapp.data.remote.OpenWeatherMapService
import com.yunusbedir.weatherapp.data.remote.model.CurrentWeatherResponse
import com.yunusbedir.weatherapp.domain.repository.OpenWeatherMapRepository
import com.yunusbedir.weatherapp.util.Dispatcher
import kotlinx.coroutines.withContext

internal class OpenWeatherMapRepositoryImpl(
    private val openWeatherMapService: OpenWeatherMapService,
    private val dispatcher: Dispatcher
) : OpenWeatherMapRepository {

    override suspend fun getCurrentWeather(lat: Double, lon: Double): CurrentWeatherResponse =
        withContext(dispatcher.io) {
            openWeatherMapService.getCurrentWeather(lat = lat, lon = lon)
        }
}