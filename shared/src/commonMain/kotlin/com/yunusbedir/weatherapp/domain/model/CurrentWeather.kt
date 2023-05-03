package com.yunusbedir.weatherapp.domain.model

import com.yunusbedir.weatherapp.util.WeatherIcon

data class CurrentWeather(
    val name: String,
    val description: String,
    val temp: String,
    val feelsLike: String,
    val tempMin: String,
    val tempMax: String,
    val pressure: String,
    val humidity: String,
    val seaLevel: String,
    val grndLevel: String,
    val icon: WeatherIcon,
    val listDayAndForeCast: List<DayAndForecast>
)

data class DayAndForecast(
    val day: String,
    val forecast: Forecast
)

data class Forecast(
    val icon: WeatherIcon,
    val tempMin: String,
    val tempMax: String,
    val dayAndHourAndMinute: String,
)
