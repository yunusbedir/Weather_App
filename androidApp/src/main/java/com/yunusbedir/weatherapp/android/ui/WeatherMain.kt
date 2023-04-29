package com.yunusbedir.weatherapp.android.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.yunusbedir.weatherapp.android.MyApplicationTheme
import com.yunusbedir.weatherapp.android.ui.common.Home
import com.yunusbedir.weatherapp.android.ui.home.HomeScreen
import com.yunusbedir.weatherapp.android.ui.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun WeatherMain(

) {
    val navController = rememberNavController()
    val systemUiController = rememberSystemUiController()
    val scaffoldState = rememberScaffoldState()

    SideEffect {
        systemUiController.isStatusBarVisible = false
    }

    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = Color.Transparent,
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Home.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = Home.route) {
                val homeViewModel: HomeViewModel = koinViewModel()
                HomeScreen(homeViewModel.uiState)
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        WeatherMain()
    }
}
