package com.ajinkyad.flickrelectrolux.data.remote.services

import com.ajinkyad.flickrelectrolux.data.remote.base.CustomException
import com.ajinkyad.flickrelectrolux.data.remote.base.Either
import com.ajinkyad.flickrelectrolux.data.remote.dto.PhotosResponseWrapper

interface FlickrImageService {

    @Throws(Exception::class)
    suspend fun fetchPhotos(): Either<CustomException, PhotosResponseWrapper>?
}