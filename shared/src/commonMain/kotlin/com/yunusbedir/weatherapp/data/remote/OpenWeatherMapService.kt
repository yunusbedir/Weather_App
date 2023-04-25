package com.yunusbedir.weatherapp.data.remote

import com.yunusbedir.weatherapp.BuildKonfig
import com.yunusbedir.weatherapp.data.remote.model.CurrentWeatherResponse
import io.ktor.client.call.*
import io.ktor.client.request.*

internal class OpenWeatherMapService : KtorApi() {

    suspend fun getCurrentWeather(lat: Double, lon: Double): CurrentWeatherResponse =
        client.get {
            pathUrl("data/2.5/weather")
            parameter("lat", lat)
            parameter("lon", lon)
        }.body()

}