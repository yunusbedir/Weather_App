package com.yunusbedir.weatherapp.android.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yunusbedir.weatherapp.android.R
import com.yunusbedir.weatherapp.android.MyApplicationTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    uiState: HomeScreenState,
    loadCurrentWeather: () -> Unit = {}
) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = uiState.refreshing,
        onRefresh = {
            loadCurrentWeather()
        })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Transparent)
            .pullRefresh(state = pullRefreshState)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Text(
                text = uiState.currentStation,
                style = MaterialTheme.typography.h3,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 56.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.rain),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)
                    .padding(top = 48.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = uiState.temp,
                    style = MaterialTheme.typography.h3,
                    color = Color.White
                )
                Text(
                    text = uiState.unitType,
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )
            }

            LazyRow(
                contentPadding = PaddingValues(4.dp),
                horizontalArrangement = Arrangement.spacedBy(0.dp),
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxHeight(1f),
                verticalAlignment = Alignment.Bottom
            ) {
                itemsIndexed(
                    items = uiState.dailyWeatherForecastItems
                ) { _, dailyWeatherForecastItem ->
                    DailyWeatherForecastItem(
                        dailyWeatherForecastItem = dailyWeatherForecastItem,
                        modifier = Modifier
                            .width(96.dp)
                            .padding(8.dp)
                    )
                }
            }
        }

        PullRefreshIndicator(
            refreshing = uiState.refreshing,
            state = pullRefreshState,
            modifier = Modifier
                .align(Alignment.TopCenter)
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        HomeScreen(HomeScreenState())
    }
}