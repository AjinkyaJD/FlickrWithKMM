package com.ajinkyad.flickrelectrolux.data.remote.base

import io.ktor.client.statement.*

class CustomException(var httpResponse: HttpResponse, var errorResponse: String?) : Exception() {

    companion object {

        fun getDefaultError(errorMessage: String?): ErrorResponse {
            return ErrorResponse(1, "Something went wrong!!", false)
        }
    }

}