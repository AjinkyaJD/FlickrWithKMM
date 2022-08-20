package com.ajinkyad.flickrelectrolux.data.remote.services

import com.ajinkyad.flickrelectrolux.data.remote.base.CustomException
import com.ajinkyad.flickrelectrolux.data.remote.base.Either
import com.ajinkyad.flickrelectrolux.domain.entity.Photo

interface FlickrImageService {

    @Throws(Exception::class)
    suspend fun fetchPhotos(query: String?): Either<CustomException, List<Photo>?>?
}