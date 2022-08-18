package com.ajinkyad.flickrelectrolux.data.remote.services

import com.ajinkyad.flickrelectrolux.data.remote.base.CustomException
import com.ajinkyad.flickrelectrolux.data.remote.base.Either
import com.ajinkyad.flickrelectrolux.data.remote.base.Failure
import com.ajinkyad.flickrelectrolux.data.remote.base.Success
import com.ajinkyad.flickrelectrolux.data.remote.dto.PhotosResponseWrapper
import com.ajinkyad.flickrelectrolux.shared.HttpBaseClient
import com.ajinkyad.flickrelectrolux.utils.EndpointConfig
import io.ktor.client.call.*
import io.ktor.client.request.*

class FlickrImageServiceImpl() : FlickrImageService {

    //Create Http Client
    private var httpClient = HttpBaseClient().httpClient

    //Required parameters for the request
    private val API_KEY = ""
    private val METHODS = "flickr.photos.search"
    private val TAGS = "Electrolux"

    override suspend fun fetchPhotos(): Either<CustomException, PhotosResponseWrapper>? {
        return try {
            val response: PhotosResponseWrapper = httpClient.get(EndpointConfig.PHOTOS_SEARCH_URL)
            {
                parameter(EndpointConfig.API_KEY, API_KEY)
                parameter(EndpointConfig.METHODS, METHODS)
                parameter(EndpointConfig.TAGS, TAGS)
            }.body()
            Success(response)
        } catch (e: Exception) {
            Failure(e as CustomException)
        }
    }

}