package com.yunusbedir.weatherapp.domain.repository

import com.yunusbedir.weatherapp.data.remote.model.CurrentWeatherResponse
import com.yunusbedir.weatherapp.data.remote.model.ForecastResponse
import com.yunusbedir.weatherapp.util.UnitType

internal interface OpenWeatherMapRepository {

    suspend fun getCurrentWeather(
        lat: Double,
        lon: Double,
        unitType: UnitType,
        lang: String
    ): CurrentWeatherResponse

    suspend fun getForecast(
        lat: Double,
        lon: Double,
        unitType: UnitType,
        lang: String
    ): ForecastResponse
}