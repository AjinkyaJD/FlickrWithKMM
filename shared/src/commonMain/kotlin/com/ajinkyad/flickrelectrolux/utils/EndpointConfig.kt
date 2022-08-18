package com.ajinkyad.flickrelectrolux.utils

object EndpointConfig {

    //App Base Url
    val BASE_URL = "https://api.flickr.com/"

    // URL for fetching the Photos
    val PHOTOS_SEARCH_URL = "$BASE_URL/services/rest"

    // Query Params for Photos Search URL
    val API_KEY = "api_key"
    val METHODS = "methods"
    val TAGS = "tags"
}