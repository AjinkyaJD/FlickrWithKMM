package com.ajinkyad.flickrelectrolux.data.remote.base

data class ErrorResponse (
    var statusMessage: String? = "",
    var success: Boolean? = false
)