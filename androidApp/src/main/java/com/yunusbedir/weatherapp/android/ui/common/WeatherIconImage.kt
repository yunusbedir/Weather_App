package com.yunusbedir.weatherapp.android.ui.common

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.yunusbedir.weatherapp.android.R
import com.yunusbedir.weatherapp.util.WeatherIcon

@Composable
fun WeatherIconImage(
    weatherIcon: WeatherIcon,
    modifier: Modifier
) {

    val resourceId = when (weatherIcon) {
        WeatherIcon.CLEAR_SKY -> R.drawable.clear_sky
        WeatherIcon.FEW_CLOUDS -> R.drawable.few_clouds
        WeatherIcon.SCATTERED_CLOUDS -> R.drawable.few_clouds
        WeatherIcon.BROKEN_CLOUDS -> R.drawable.few_clouds
        WeatherIcon.SHOWER_RAIN -> R.drawable.shower_rain
        WeatherIcon.RAIN -> R.drawable.rain
        WeatherIcon.THUNDERSTORM -> R.drawable.thunderstorm
        WeatherIcon.SNOW -> R.drawable.snow
        WeatherIcon.MIST -> R.drawable.few_clouds
    }

    Image(
        painter = painterResource(id = resourceId),
        contentDescription = null,
        modifier = modifier
    )
}