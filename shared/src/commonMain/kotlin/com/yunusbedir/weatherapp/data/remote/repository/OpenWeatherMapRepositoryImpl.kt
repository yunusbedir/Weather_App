package com.yunusbedir.weatherapp.data.remote.repository

import com.yunusbedir.weatherapp.data.remote.OpenWeatherMapService
import com.yunusbedir.weatherapp.data.remote.model.CurrentWeatherResponse
import com.yunusbedir.weatherapp.data.remote.model.ForecastResponse
import com.yunusbedir.weatherapp.domain.repository.OpenWeatherMapRepository
import com.yunusbedir.weatherapp.util.Dispatcher
import com.yunusbedir.weatherapp.util.UnitType
import kotlinx.coroutines.withContext

internal class OpenWeatherMapRepositoryImpl(
    private val openWeatherMapService: OpenWeatherMapService,
    private val dispatcher: Dispatcher
) : OpenWeatherMapRepository {

    override suspend fun getCurrentWeather(
        lat: Double,
        lon: Double,
        unitType: UnitType,
        lang: String
    ): CurrentWeatherResponse =
        withContext(dispatcher.io) {
            openWeatherMapService.getCurrentWeather(
                lat = lat,
                lon = lon,
                unitType.text,
                lang
            )
        }

    override suspend fun getForecast(
        lat: Double,
        lon: Double,
        unitType: UnitType,
        lang: String
    ): ForecastResponse =
        withContext(dispatcher.io) {
            openWeatherMapService.getForecast(
                lat = lat,
                lon = lon,
                unitType.text,
                lang
            )
        }
}