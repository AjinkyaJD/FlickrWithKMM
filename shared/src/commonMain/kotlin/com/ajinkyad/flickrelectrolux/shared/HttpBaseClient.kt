package com.ajinkyad.flickrelectrolux.shared

import io.ktor.client.*

expect class HttpBaseClient() {
    val httpClient: HttpClient
}