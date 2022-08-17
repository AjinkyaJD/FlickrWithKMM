package com.ajinkyad.flickrelectrolux.shared

import com.ajinkyad.flickrelectrolux.data.remote.base.CustomException
import com.ajinkyad.flickrelectrolux.utils.EndpointConfig
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

actual class HttpBaseClient {
    actual val httpClient: HttpClient = HttpClient {
        defaultRequest {
            url {
                host = EndpointConfig.BASE_URL
                // Default params for the search photos query
                parameters.append("nojsoncallback", "true")
                parameters.append("extras", "media")
                parameters.append("extras", "url_sq")
                parameters.append("extras", "url_m")
                parameters.append("per_page", "21")
                parameters.append("page", "1")
            }
            contentType(ContentType.Application.Json)
        }
        // Validate Response
        expectSuccess = false
        // JSON Deserializer
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
        HttpResponseValidator {
            validateResponse {
                handleResponseExceptionWithRequest { exception, _ ->
                    //Handling the exception in the response
                    val clientException = exception as? ClientRequestException
                        ?: return@handleResponseExceptionWithRequest
                    val exceptionResponse = clientException.response
                    if (exceptionResponse.status == HttpStatusCode.NotFound) {
                        val exceptionResponseText = exceptionResponse.bodyAsText()
                        throw CustomException(exceptionResponse, exceptionResponseText)
                    }
                }
            }
        }
    }
}