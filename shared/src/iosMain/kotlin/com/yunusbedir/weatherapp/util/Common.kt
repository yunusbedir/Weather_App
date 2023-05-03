package com.yunusbedir.weatherapp.util

import platform.Foundation.NSLocale
import platform.Foundation.countryCode
import platform.Foundation.currentLocale
import platform.Foundation.languageCode

actual val myLang: String
    get() = NSLocale.currentLocale.languageCode
actual val myCountry: String
    get() = NSLocale.currentLocale.countryCode ?: "tr"
