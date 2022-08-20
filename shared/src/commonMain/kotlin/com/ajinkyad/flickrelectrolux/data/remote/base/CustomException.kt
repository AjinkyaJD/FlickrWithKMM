package com.ajinkyad.flickrelectrolux.data.remote.base

class CustomException(var errorResponse: String?) : Exception() {

    companion object {

        fun getDefaultError(errorMessage: String?): ErrorResponse {
            return ErrorResponse("Something went wrong!!", false)
        }
    }

}