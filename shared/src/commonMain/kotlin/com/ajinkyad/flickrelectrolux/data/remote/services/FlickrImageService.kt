package com.ajinkyad.flickrelectrolux.data.remote.services

import com.ajinkyad.flickrelectrolux.data.remote.base.CustomException
import com.ajinkyad.flickrelectrolux.data.remote.base.Either
import com.ajinkyad.flickrelectrolux.data.remote.dto.PhotoResponse
import com.ajinkyad.flickrelectrolux.data.remote.dto.PhotosResponse
import com.ajinkyad.flickrelectrolux.data.remote.dto.PhotosResponseWrapper
import io.ktor.client.statement.*

interface FlickrImageService {

    @Throws(Exception::class)
    suspend fun fetchPhotos(): Either<CustomException, List<PhotoResponse>?>?
}