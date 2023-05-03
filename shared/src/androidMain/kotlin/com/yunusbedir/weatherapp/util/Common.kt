package com.yunusbedir.weatherapp.util

import java.util.*

actual val myLang: String
    get() = Locale.getDefault().language
actual val myCountry: String
    get() = Locale.getDefault().country
