package com.yunusbedir.weatherapp.data.remote.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
internal data class CurrentWeatherResponse(
    val coord: CurrentWeatherResponseCoord,
    val weather: List<CurrentWeatherResponseWeather>,
    val base: String,
    val main: CurrentWeatherResponseMain,
    val visibility: Int,
    val wind: CurrentWeatherResponseWind,
    var rain: CurrentWeatherResponseRain? = null,
    var clouds: CurrentWeatherResponseClouds? = null,
    val dt: Long,
    val sys: CurrentWeatherResponseSys,
    val timezone: Int,
    val id: Int,
    val name: String,
    val cod: Int,
)

@kotlinx.serialization.Serializable
internal data class CurrentWeatherResponseCoord(
    val lon: Double,
    val lat: Double
)

@kotlinx.serialization.Serializable
internal data class CurrentWeatherResponseWeather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

@kotlinx.serialization.Serializable
internal data class CurrentWeatherResponseMain(
    val temp: Double,
    @SerialName("feels_like")
    val feelsLike: Double,
    @SerialName("temp_min")
    val tempMin: Double,
    @SerialName("temp_max")
    val tempMax: Double,
    val pressure: Int,
    val humidity: Int,
    @SerialName("sea_level")
    var seaLevel: Int?= null,
    @SerialName("grnd_level")
    var grndLevel: Int? = null
)

@kotlinx.serialization.Serializable
internal data class CurrentWeatherResponseWind(
    val speed: Double,
    val deg: Int,
    var gust: Double? = null
)

@kotlinx.serialization.Serializable
internal data class CurrentWeatherResponseRain(
    @SerialName("1h")
    val oneHour: Double,
)

@kotlinx.serialization.Serializable
internal data class CurrentWeatherResponseClouds(
    val all: Int,
)

@kotlinx.serialization.Serializable
internal data class CurrentWeatherResponseSys(
    val country: String? = null,
    val sunrise: Long? = null,
    val sunset: Long? = null,
)


/*
{
    "coord": {
        "lon": 49,
        "lat": 49
    },
    "weather": [
        {
            "id": 500,
            "main": "Rain",
            "description": "light rain",
            "icon": "10d"
        }
    ],
    "base": "stations",
    "main": {
        "temp": 289.06,
        "feels_like": 288.33,
        "temp_min": 289.06,
        "temp_max": 289.06,
        "pressure": 1014,
        "humidity": 62,
        "sea_level": 1014,
        "grnd_level": 1015
    },
    "visibility": 10000,
    "wind": {
        "speed": 9.35,
        "deg": 163,
        "gust": 13.31
    },
    "rain": {
        "1h": 0.38
    },
    "clouds": {
        "all": 100
    },
    "dt": 1682417454,
    "sys": {
        "country": "KZ",
        "sunrise": 1682386478,
        "sunset": 1682437748
    },
    "timezone": 18000,
    "id": 610242,
    "name": "Baldyrgan",
    "cod": 200
}*/

/**
 *
@kotlinx.serialization.Serializable
internal internal data class MovieRemote(
val id: Int,
val title: String,
val overview: String,
@SerialName("poster_path")
val posterImage: String,
@SerialName("release_date")
val releaseDate: String

)



 */