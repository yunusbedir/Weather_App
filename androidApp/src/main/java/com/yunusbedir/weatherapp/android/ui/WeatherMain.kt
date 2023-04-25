package com.yunusbedir.weatherapp.android.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.yunusbedir.weatherapp.android.ui.common.Home
import com.yunusbedir.weatherapp.android.ui.common.WeatherAppBar
import com.yunusbedir.weatherapp.android.ui.common.weatherAppDestinations
import com.yunusbedir.weatherapp.android.ui.home.HomeScreen
import com.yunusbedir.weatherapp.android.ui.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun WeatherMain(

) {
    val navController = rememberNavController()
    val systemUiController = rememberSystemUiController()
    val scaffoldState = rememberScaffoldState()

    val isSystemDark = isSystemInDarkTheme()
    val statusBarColor = if (isSystemDark) {
        MaterialTheme.colors.primaryVariant
    } else {
        Color.Transparent
    }

    SideEffect {
        systemUiController.setStatusBarColor(color = statusBarColor, darkIcons = !isSystemDark)
    }

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = weatherAppDestinations.find {
        backStackEntry?.destination?.route == it.route ||
                backStackEntry?.destination?.route == it.routeWithArgs
    } ?: Home

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            WeatherAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                canMoreVert = currentScreen.route == Home.route,
                currentScreen = currentScreen,
                onNavigateBack = { navController.navigateUp() },
                onAddClicked = {  },
                onMoreVertClicked = {}
            )
        }
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
                HomeScreen(homeViewModel)
            }
        }
    }
}