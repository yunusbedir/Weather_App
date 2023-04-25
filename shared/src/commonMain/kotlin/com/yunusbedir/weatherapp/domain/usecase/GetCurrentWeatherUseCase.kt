package com.yunusbedir.weatherapp.domain.usecase

import com.yunusbedir.weatherapp.data.remote.model.CurrentWeatherResponse
import com.yunusbedir.weatherapp.domain.model.CurrentWeather
import com.yunusbedir.weatherapp.domain.repository.OpenWeatherMapRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetCurrentWeatherUseCase : KoinComponent {

    private val repository: OpenWeatherMapRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(lat: Double, lon: Double): CurrentWeather {
        return repository.getCurrentWeather(lat = lat, lon = lon).toModel()
    }

    private fun CurrentWeatherResponse.toModel(): CurrentWeather {
        return CurrentWeather(
            name = name,
            description = weather.firstOrNull()?.description.toString(),
            temp = main.temp.toString(),
            feelsLike = main.feelsLike.toString(),
            tempMin = main.tempMin.toString(),
            tempMax = main.tempMax.toString(),
            pressure = main.pressure.toString(),
            humidity = main.humidity.toString(),
            seaLevel = main.seaLevel.toString(),
            grndLevel = main.grndLevel.toString()
        )
    }
}