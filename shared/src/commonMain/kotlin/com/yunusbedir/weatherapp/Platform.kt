package com.yunusbedir.weatherapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform