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
        install(Logging)
    }

    fun HttpRequestBuilder.pathUrl(path: String) {
        url {
            takeFrom(BuildKonfig.BASE_URL)
            path(path)
            parameter("appid", BuildKonfig.API_KEY)
        }
    }
}