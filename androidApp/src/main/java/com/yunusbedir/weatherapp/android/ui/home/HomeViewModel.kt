package com.yunusbedir.weatherapp.android.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yunusbedir.weatherapp.domain.usecase.GetCurrentWeatherUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
) : ViewModel() {

    init {
        getCurrentWeather()
    }

    private fun getCurrentWeather(){
        viewModelScope.launch {
            val response = getCurrentWeatherUseCase.invoke(49.00,49.00)
            Log.i("MY_TAG", "response : $response")
        }
    }
}