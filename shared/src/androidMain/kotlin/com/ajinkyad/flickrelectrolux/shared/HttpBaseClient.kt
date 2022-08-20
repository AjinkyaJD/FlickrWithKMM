package com.ajinkyad.flickrelectrolux.shared

import com.ajinkyad.flickrelectrolux.data.remote.base.CustomException
import com.ajinkyad.flickrelectrolux.utils.EndpointConfig
import com.ajinkyad.flickrelectrolux.utils.EndpointConfig.PAGE_NUMBER
import com.ajinkyad.flickrelectrolux.utils.EndpointConfig.RECORDS_PER_PAGE
import com.ajinkyad.flickrelectrolux.utils.QueryParamsKey.API_KEY
import com.ajinkyad.flickrelectrolux.utils.QueryParamsKey.EXTRAS
import com.ajinkyad.flickrelectrolux.utils.QueryParamsKey.FORMAT
import com.ajinkyad.flickrelectrolux.utils.QueryParamsKey.NO_JSON_CALLBACK
import com.ajinkyad.flickrelectrolux.utils.QueryParamsKey.PAGE
import com.ajinkyad.flickrelectrolux.utils.QueryParamsKey.PER_PAGE
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

actual class HttpBaseClient {

    actual val httpClient: HttpClient = HttpClient {
        install(DefaultRequest) {
            url {
                protocol = URLProtocol.HTTPS
                host = EndpointConfig.BASE_URL
                // Default params for the search photos query
                parameters.append(API_KEY, "c4ea75175cb00f4a23e73fbd5d8387d4")
                parameters.append(FORMAT, "json")
                parameters.append(NO_JSON_CALLBACK, "true")
                parameters.append(EXTRAS, "media")
                parameters.append(EXTRAS, "url_sq")
                parameters.append(EXTRAS, "url_m")
                parameters.append(PER_PAGE, RECORDS_PER_PAGE)
                parameters.append(PAGE, PAGE_NUMBER)
            }
            contentType(ContentType.Application.Json)
        }
        // Validate Response
        expectSuccess = false
        // Network Call Logging
        install(Logging) {
            level = LogLevel.ALL
        }
        // JSON Deserializer
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                encodeDefaults = false
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
                        throw CustomException(exceptionResponseText)
                    }
                }
            }
        }
    }
}