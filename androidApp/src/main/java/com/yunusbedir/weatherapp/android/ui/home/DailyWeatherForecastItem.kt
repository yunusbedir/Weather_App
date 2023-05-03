package com.yunusbedir.weatherapp.android.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.yunusbedir.weatherapp.android.ui.common.WeatherIconImage
import com.yunusbedir.weatherapp.domain.model.DayAndForecast

@Composable
fun DailyWeatherForecastItem(
    dayAndForecast: DayAndForecast,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                Brush.linearGradient(
                    listOf(Color(0xFF97ABFF), Color.Transparent),
                    tileMode = TileMode.Repeated
                ),
                shape = RoundedCornerShape(25.dp),
                alpha = 0.6f
            )
    ) {

        Column(
            modifier = Modifier
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = dayAndForecast.forecast.dayAndHourAndMinute,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle.Default.copy(
                    color = Color.White
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            WeatherIconImage(
                weatherIcon = dayAndForecast.forecast.icon,
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp)
                    .align(Alignment.CenterHorizontally)

            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${dayAndForecast.forecast.tempMin}/${dayAndForecast.forecast.tempMax}",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle.Default.copy(
                    color = Color.White
                )
            )

        }

    }
}