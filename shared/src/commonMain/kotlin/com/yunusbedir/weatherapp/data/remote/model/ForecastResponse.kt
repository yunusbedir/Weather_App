package com.yunusbedir.weatherapp.data.remote.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
internal data class ForecastResponse(
    val cod: String,
    val message: Int,
    val cnt: Int,
    val list: List<ListItemForecastResponse>
)

@kotlinx.serialization.Serializable
internal data class ListItemForecastResponse(
    val dt: Long,
    val main: CurrentWeatherResponseMain,
    val weather: List<CurrentWeatherResponseWeather>,
    var clouds: CurrentWeatherResponseClouds? = null,
    val wind: CurrentWeatherResponseWind,
    val visibility: Int,
    val pop: Double,
    val sys: CurrentWeatherResponseSys,
    @SerialName("dt_txt")
    val dtTxt: String,
)

/*
{
    "cod": "200",
    "message": 0,
    "cnt": 40,
    "list": [
    {
        "dt": 1682974800,
        "main": {
            "temp": 16.96,
            "feels_like": 16.41,
            "temp_min": 16.96,
            "temp_max": 16.96,
            "pressure": 1014,
            "sea_level": 1014,
            "grnd_level": 1015,
            "humidity": 65,
            "temp_kf": 0
        },
        "weather": [
        {
            "id": 804,
            "main": "Clouds",
            "description": "kapalı",
            "icon": "04n"
        }
        ],
        "clouds": {
            "all": 96
        },
        "wind": {
            "speed": 3.2,
            "deg": 320,
            "gust": 5.51
        },
        "visibility": 10000,
        "pop": 0.04,
            "sys": {
            "pod": "n"
        },
        "dt_txt": "2023-05-01 21:00:00"
    },*/

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