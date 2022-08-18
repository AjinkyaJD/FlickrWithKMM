package com.ajinkyad.flickrelectrolux.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotosResponse(
    val page: Int = 0,
    val pages: Int = 0,
    @SerialName("perpage")
    val perPage: Int = 0,
    val total: Int = 0,
    val photo: List<PhotoResponse>? = null
)
