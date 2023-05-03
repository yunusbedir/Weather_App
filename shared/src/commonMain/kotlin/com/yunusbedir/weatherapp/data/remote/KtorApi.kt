package com.yunusbedir.weatherapp.data.remote

import com.yunusbedir.weatherapp.BuildKonfig
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

internal abstract class KtorApi {

    val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                }
            )
        }
        install(Logging)  {
            logger = object : Logger {
                override fun log(message: String) {
                    println("loggerTag: $message") // Or whatever logging system you want here
                }
            }
            level = LogLevel.ALL
        }
    }

    fun HttpRequestBuilder.pathUrl(path: String) {
        url {
            takeFrom(BuildKonfig.BASE_URL)
            path(path)
            parameter("appid", BuildKonfig.API_KEY)
        }
    }
}