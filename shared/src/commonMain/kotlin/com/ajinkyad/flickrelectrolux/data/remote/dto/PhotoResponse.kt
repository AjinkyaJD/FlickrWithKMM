package com.ajinkyad.flickrelectrolux.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoResponse(
    val id: String? = null,
    val owner: String? = null,
    val secret: String? = null,
    val server: String? = null,
    val farm: Int = 0,
    val title: String? = null,
    @SerialName("ispublic")
    val isPublic: Boolean = false,
    @SerialName("isfriend")
    val isFriend: Boolean = false,
    @SerialName("isfamily")
    val isFamily: Boolean = false,
    @SerialName("url_m")
    val url: String? = null,
    @SerialName("height_m")
    val height: Int = 0,
    @SerialName("width_m")
    val width: Int = 0
)
