package com.ajinkyad.flickrelectrolux.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoResponse(
    @SerialName("id")
    val id: String? = null,
    @SerialName("owner")
    val owner: String? = null,
    @SerialName("secret")
    val secret: String? = null,
    @SerialName("server")
    val server: String? = null,
    @SerialName("farm")
    val farm: Int = 0,
    @SerialName("title")
    val title: String? = null,
    @SerialName("ispublic")
    val isPublic: Int = 0,
    @SerialName("isfriend")
    val isFriend: Int = 0,
    @SerialName("isfamily")
    val isFamily: Int = 0,
    @SerialName("url_m")
    val url: String? = null,
    @SerialName("height_m")
    val height: Int = 0,
    @SerialName("width_m")
    val width: Int = 0
)
