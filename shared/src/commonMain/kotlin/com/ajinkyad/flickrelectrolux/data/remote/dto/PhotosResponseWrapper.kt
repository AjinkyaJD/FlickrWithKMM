package com.ajinkyad.flickrelectrolux.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotosResponseWrapper(
    @SerialName("photos")
    val photos: PhotosResponse? = null,
    @SerialName("stat")
    val stat: String? = null
)
