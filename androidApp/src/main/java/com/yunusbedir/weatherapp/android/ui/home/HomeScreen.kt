package com.yunusbedir.weatherapp.android.ui.home

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yunusbedir.weatherapp.android.MyApplicationTheme
import com.yunusbedir.weatherapp.android.R

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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier
                        .size(56.dp)
                        .padding(8.dp)
                        .align(Alignment.CenterVertically)
                        .clickable(MutableInteractionSource(), null) {
                            //onDeleteClick()
                        },
                    tint = Color.White
                )

                Text(
                    text = uiState.currentStation,
                    style = MaterialTheme.typography.h4,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(top = 8.dp),
                    textAlign = TextAlign.Center
                )

                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null,
                    modifier = Modifier
                        .size(56.dp)
                        .padding(8.dp)
                        .clickable(MutableInteractionSource(), null) {
                            //onDeleteClick()
                        },
                    tint = Color.White
                )

            }

            Image(
                painter = painterResource(id = R.drawable.rain),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)
                    .padding(top = 48.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
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

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = uiState.weatherDescription,
                        style = MaterialTheme.typography.body2,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "${uiState.tempMin} - ${uiState.tempMax}",
                        style = MaterialTheme.typography.body2,
                        color = Color.White
                    )
                }

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