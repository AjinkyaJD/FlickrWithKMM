package com.ajinkyad.flickrelectrolux.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotosResponse(
    @SerialName("page")
    val page: Int = 0,
    @SerialName("pages")
    val pages: Int = 0,
    @SerialName("perpage")
    val perPage: Int = 0,
    @SerialName("total")
    val total: Int = 0,
    @SerialName("photo")
    val photo: List<PhotoResponse>? = null
)
