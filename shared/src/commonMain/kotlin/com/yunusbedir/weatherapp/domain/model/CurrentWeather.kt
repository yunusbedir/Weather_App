package com.yunusbedir.weatherapp.domain.model

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
    val grndLevel: String
)
