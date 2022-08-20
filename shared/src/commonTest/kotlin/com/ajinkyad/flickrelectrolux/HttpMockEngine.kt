package com.ajinkyad.flickrelectrolux

import com.ajinkyad.flickrelectrolux.data.remote.services.FlickrImageService
import com.ajinkyad.flickrelectrolux.data.remote.services.FlickrImageServiceImpl
import com.ajinkyad.flickrelectrolux.mockResponse.PhotoMockResponseWrapper
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*


class HttpMockEngine {

    fun mockFlickerAPISuccessResponse(): FlickrImageService {
        return mockFlickerAPIResponse(
            HttpStatusCode.OK,
            PhotoMockResponseWrapper.successfulResponse()
        )
    }

    fun mockFlickerAPISuccessResponseWithDifferentTag(): FlickrImageService {
        return mockFlickerAPIResponse(
            HttpStatusCode.OK,
            PhotoMockResponseWrapper.successfulResponseWithDifferentTag()
        )
    }

    fun mockFlickerAPIEmptyResponse(): FlickrImageService {
        return mockFlickerAPIResponse(
            HttpStatusCode.OK,
            PhotoMockResponseWrapper.emptyPhotosResponse()
        )
    }

    private fun mockFlickerAPIResponse(
        status: HttpStatusCode,
        mockResponse: String
    ): FlickrImageService {
        val engine = MockEngine {
            respond(
                content = mockResponse,
                status = status,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val httpClient = HttpClient(engine) {
            install(ContentNegotiation) {
                json()
            }
        }

        return FlickrImageServiceImpl(httpClient)
    }
}