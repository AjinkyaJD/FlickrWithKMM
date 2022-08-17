package com.ajinkyad.flickrelectrolux.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PhotosResponseWrapper(
    val photos: PhotosResponse? = null
)
