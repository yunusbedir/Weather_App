package com.yunusbedir.weatherapp.android.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yunusbedir.weatherapp.android.MyApplicationTheme
import com.yunusbedir.weatherapp.android.R

@Composable
fun DailyWeatherForecastItem(
    dailyWeatherForecastItem: HomeScreenState.DailyWeatherForecastItem,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .background(
                Brush.linearGradient(
                    listOf(Color(0xFF97ABFF), Color.White),
                    tileMode = TileMode.Repeated
                ),
                shape = RoundedCornerShape(96.dp),
                alpha = 0.5f
            ),
        shape = RoundedCornerShape(96.dp),
        backgroundColor = Color.Transparent
    ) {

        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = dailyWeatherForecastItem.date,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle.Default.copy(
                    color = Color.White
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = R.drawable.rain),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = dailyWeatherForecastItem.temp,
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


@Preview
@Composable
fun DefaultPreview2() {
    MyApplicationTheme {
        DailyWeatherForecastItem(HomeScreenState.DailyWeatherForecastItem())
    }
}