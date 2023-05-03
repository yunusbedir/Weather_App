package com.yunusbedir.weatherapp.android.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yunusbedir.weatherapp.domain.model.DayAndForecast
import com.yunusbedir.weatherapp.domain.model.Forecast
import com.yunusbedir.weatherapp.domain.usecase.GetCurrentWeatherUseCase
import com.yunusbedir.weatherapp.util.WeatherIcon
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
) : ViewModel() {

    var uiState by mutableStateOf(HomeScreenState())
        private set

    init {
        getCurrentWeather()
    }

    private fun getCurrentWeather() {
        viewModelScope.launch {
            try {

                val response = getCurrentWeatherUseCase.invoke(40.953296, 29.279649)
                uiState = uiState.copy(
                    temp = response.temp,
                    weatherDescription = response.description,
                    tempMin = response.tempMin,
                    tempMax = response.tempMax,
                    humidity = response.humidity,
                    currentStation = response.name,
                    dailyWeatherForecastItems = response.listDayAndForeCast
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

data class HomeScreenState(
    val temp: String = "34",
    val weatherDescription: String = "Parçalı Bulutlu",
    val tempMin: String = "23",
    val tempMax: String = "36",
    val humidity: String = "32",
    val unitType: String = "C",
    val currentStation: String = "Sultanbeyli",
    val dailyWeatherForecastItems: List<DayAndForecast> = listOf(
        DayAndForecast(
            day = "14:12",
            forecast = Forecast(
                icon = WeatherIcon.CLEAR_SKY,
                tempMin = "12",
                tempMax = "21",
                dayAndHourAndMinute = "1",
            )
        ),
        DayAndForecast(
            day = "14:12",
            forecast = Forecast(
                icon = WeatherIcon.CLEAR_SKY,
                tempMin = "12",
                tempMax = "21",
                dayAndHourAndMinute = "1",
            )
        ),
        DayAndForecast(
            day = "14:12",
            forecast = Forecast(
                icon = WeatherIcon.CLEAR_SKY,
                tempMin = "12",
                tempMax = "21",
                dayAndHourAndMinute = "1",
            )
        ),
        DayAndForecast(
            day = "14:12",
            forecast = Forecast(
                icon = WeatherIcon.CLEAR_SKY,
                tempMin = "12",
                tempMax = "21",
                dayAndHourAndMinute = "1",
            )
        ),
        DayAndForecast(
            day = "14:12",
            forecast = Forecast(
                icon = WeatherIcon.CLEAR_SKY,
                tempMin = "12",
                tempMax = "21",
                dayAndHourAndMinute = "1",
            )
        ),
        DayAndForecast(
            day = "14:12",
            forecast = Forecast(
                icon = WeatherIcon.CLEAR_SKY,
                tempMin = "12",
                tempMax = "21",
                dayAndHourAndMinute = "1",
            )
        ),
    ),
    val refreshing: Boolean = false
)