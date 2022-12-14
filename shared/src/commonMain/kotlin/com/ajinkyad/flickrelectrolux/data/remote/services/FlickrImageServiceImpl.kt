package com.ajinkyad.flickrelectrolux.data.remote.services

import com.ajinkyad.flickrelectrolux.data.remote.base.CustomException
import com.ajinkyad.flickrelectrolux.data.remote.base.Either
import com.ajinkyad.flickrelectrolux.data.remote.base.Failure
import com.ajinkyad.flickrelectrolux.data.remote.base.Success
import com.ajinkyad.flickrelectrolux.data.remote.dto.PhotosResponseWrapper
import com.ajinkyad.flickrelectrolux.domain.entity.Photo
import com.ajinkyad.flickrelectrolux.utils.EndpointConfig
import com.ajinkyad.flickrelectrolux.utils.QueryParamsKey.METHOD
import com.ajinkyad.flickrelectrolux.utils.QueryParamsKey.TAGS
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class FlickrImageServiceImpl(val httpClient: HttpClient) : FlickrImageService {

    override suspend fun fetchPhotos(query: String?): Either<CustomException, List<Photo>?>? {
        return try {
            val response: List<Photo>? = httpClient.get(EndpointConfig.PHOTOS_SEARCH_URL)
            {

                parameter(METHOD, "flickr.photos.search")
                parameter(TAGS, query ?: "Electrolux")
            }
                .body<PhotosResponseWrapper>().photos?.photo?.filter { photoItem -> !photoItem.url.isNullOrEmpty() }
                ?.map { it.toPhoto() }
            Success(response)
        } catch (e: Exception) {
            //Typecast the Error Response
            val exceptionResponse = e.message
            Failure(CustomException(errorResponse = exceptionResponse))
        }
    }

}