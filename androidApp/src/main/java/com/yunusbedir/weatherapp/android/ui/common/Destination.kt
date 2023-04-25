package com.yunusbedir.weatherapp.android.ui.common

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Destination {
    val title: String
    val route: String
    val routeWithArgs: String
}

object Home : Destination {
    override val title: String
        get() = "Current"
    override val route: String
        get() = "home"
    override val routeWithArgs: String
        get() = route
}

object Detail : Destination {
    override val title: String
        get() = "Detail"
    override val route: String
        get() = "detail"
    override val routeWithArgs: String
        get() = route

    val arguments = listOf<NamedNavArgument>()
}

val weatherAppDestinations = listOf(
    Home,
    Detail
)