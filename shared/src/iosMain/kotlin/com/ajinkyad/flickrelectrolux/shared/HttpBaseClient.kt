package com.ajinkyad.flickrelectrolux.shared

import io.ktor.client.*

// TODO - Implement the iOS Base Client here
actual class HttpBaseClient {
    actual val httpClient: HttpClient = HttpClient()
}