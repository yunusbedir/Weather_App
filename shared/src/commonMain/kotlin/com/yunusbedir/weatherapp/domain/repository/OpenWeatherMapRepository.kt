package com.yunusbedir.weatherapp.domain.repository

import com.yunusbedir.weatherapp.data.remote.model.CurrentWeatherResponse

internal interface OpenWeatherMapRepository {

    suspend fun getCurrentWeather(lat: Double, lon: Double): CurrentWeatherResponse
}