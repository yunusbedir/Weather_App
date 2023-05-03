package com.yunusbedir.weatherapp.data.remote

import com.yunusbedir.weatherapp.data.remote.model.CurrentWeatherResponse
import com.yunusbedir.weatherapp.data.remote.model.ForecastResponse
import io.ktor.client.call.*
import io.ktor.client.request.*

internal class OpenWeatherMapService : KtorApi() {

    suspend fun getCurrentWeather(
        lat: Double,
        lon: Double,
        unit: String,
        lang: String
    ): CurrentWeatherResponse =
        client.get {
            pathUrl("data/2.5/weather")
            parameter("lat", lat)
            parameter("lon", lon)
            parameter("units", unit)
            parameter("lang", lang)
        }.body()

    suspend fun getForecast(
        lat: Double,
        lon: Double,
        unit: String,
        lang: String
    ): ForecastResponse =
        client.get {
            pathUrl("data/2.5/forecast")
            parameter("lat", lat)
            parameter("lon", lon)
            parameter("units", unit)
            parameter("lang", lang)
        }.body()

}