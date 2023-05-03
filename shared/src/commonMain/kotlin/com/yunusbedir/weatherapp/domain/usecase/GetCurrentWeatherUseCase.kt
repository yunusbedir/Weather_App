package com.yunusbedir.weatherapp.domain.usecase

import com.yunusbedir.weatherapp.data.remote.model.CurrentWeatherResponse
import com.yunusbedir.weatherapp.data.remote.model.ForecastResponse
import com.yunusbedir.weatherapp.domain.model.CurrentWeather
import com.yunusbedir.weatherapp.domain.model.DayAndForecast
import com.yunusbedir.weatherapp.domain.model.Forecast
import com.yunusbedir.weatherapp.domain.repository.OpenWeatherMapRepository
import com.yunusbedir.weatherapp.util.DateTimeUtil
import com.yunusbedir.weatherapp.util.UnitType
import com.yunusbedir.weatherapp.util.WeatherIcon
import com.yunusbedir.weatherapp.util.myLang
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetCurrentWeatherUseCase : KoinComponent {

    private val repository: OpenWeatherMapRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(
        lat: Double,
        lon: Double,
        unitType: UnitType = UnitType.METRIC,
        lang: String = myLang
    ): CurrentWeather {
        val forecast = repository.getForecast(
            lat = lat,
            lon = lon,
            unitType = unitType,
            lang = lang
        ).toModel()

        val currentWeather = repository.getCurrentWeather(
            lat = lat,
            lon = lon,
            unitType = unitType,
            lang = lang
        ).toModel(forecast)

        return currentWeather
    }

    private fun CurrentWeatherResponse.toModel(forecast: List<DayAndForecast>): CurrentWeather {
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
            grndLevel = main.grndLevel.toString(),
            icon = WeatherIcon.getWeatherIcon(
                weather.firstOrNull()?.icon.toString()
            ),
            listDayAndForeCast = forecast
        )
    }

    private fun ForecastResponse.toModel(): List<DayAndForecast> {
        return list.map {
            val dt = DateTimeUtil.toLocalDateTime(it.dt)
            DayAndForecast(
                day = dt.dayOfMonth.toString(),
                forecast = Forecast(
                    icon = WeatherIcon.getWeatherIcon(
                        it.weather.firstOrNull()?.icon.toString()
                    ),
                    tempMin = it.main.tempMin.toString(),
                    tempMax = it.main.tempMax.toString(),
                    dayAndHourAndMinute = DateTimeUtil.formatUiForecast(dateText = it.dtTxt),
                )
            )
        }
    }
}