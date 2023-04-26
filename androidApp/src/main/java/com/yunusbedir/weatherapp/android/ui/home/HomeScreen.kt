package com.yunusbedir.weatherapp.android.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
                .verticalScroll(rememberScrollState())
                .background(color = Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = uiState.temp,
                        style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colors.onBackground
                    )
                    Text(
                        text = uiState.unitType,
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.onBackground
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.rain),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                )

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