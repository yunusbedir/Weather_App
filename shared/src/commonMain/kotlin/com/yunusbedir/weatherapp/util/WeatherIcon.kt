package com.yunusbedir.weatherapp.util

enum class WeatherIcon(val ids: List<String>) {
    CLEAR_SKY(
        listOf("01d", "01n")
    ),
    FEW_CLOUDS(
        listOf("02d", "02n")
    ),
    SCATTERED_CLOUDS(
        listOf("03d", "03n")
    ),
    BROKEN_CLOUDS(
        listOf("04d", "04n")
    ),
    SHOWER_RAIN(
        listOf("09d", "09n")
    ),
    RAIN(
        listOf("10d", "10n")
    ),
    THUNDERSTORM(
        listOf("11d", "11n")
    ),
    SNOW(
        listOf("13d", "13n")
    ),
    MIST(
        listOf("50d", "50n")
    );

    companion object {
        fun getWeatherIcon(id: String): WeatherIcon {
            return WeatherIcon.values().firstOrNull {
                it.ids.contains(id)
            } ?: CLEAR_SKY
        }
    }
}