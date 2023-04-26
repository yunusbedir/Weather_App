package com.yunusbedir.weatherapp.android.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yunusbedir.weatherapp.domain.usecase.GetCurrentWeatherUseCase
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
            val response = getCurrentWeatherUseCase.invoke(40.953296, 29.279649)
            uiState = uiState.copy(
                temp = response.temp,
                weatherDescription = response.description,
                tempMin = response.tempMin,
                tempMax = response.tempMax,
                humidity = response.humidity,
                currentStation = response.name
            )
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
    val dailyWeatherForecastItems: List<DailyWeatherForecastItem> = listOf(
        DailyWeatherForecastItem(),DailyWeatherForecastItem(),DailyWeatherForecastItem(),DailyWeatherForecastItem(),DailyWeatherForecastItem(),DailyWeatherForecastItem(),DailyWeatherForecastItem(),DailyWeatherForecastItem(),DailyWeatherForecastItem(),DailyWeatherForecastItem(),DailyWeatherForecastItem()
    ),
    val refreshing: Boolean = false
) {
    data class DailyWeatherForecastItem(
        val temp: String = "34",
        val date: String = "Now",
        val icon: String = ""
    )
}