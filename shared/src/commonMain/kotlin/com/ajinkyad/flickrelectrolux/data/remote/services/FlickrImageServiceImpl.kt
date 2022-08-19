package com.ajinkyad.flickrelectrolux.data.remote.services

import com.ajinkyad.flickrelectrolux.data.remote.base.CustomException
import com.ajinkyad.flickrelectrolux.data.remote.base.Either
import com.ajinkyad.flickrelectrolux.data.remote.base.Failure
import com.ajinkyad.flickrelectrolux.data.remote.base.Success
import com.ajinkyad.flickrelectrolux.data.remote.dto.PhotoResponse
import com.ajinkyad.flickrelectrolux.data.remote.dto.PhotosResponseWrapper
import com.ajinkyad.flickrelectrolux.shared.HttpBaseClient
import com.ajinkyad.flickrelectrolux.utils.EndpointConfig
import com.ajinkyad.flickrelectrolux.utils.QueryParamsKey.METHOD
import com.ajinkyad.flickrelectrolux.utils.QueryParamsKey.TAGS
import io.ktor.client.call.*
import io.ktor.client.request.*

class FlickrImageServiceImpl() : FlickrImageService {

    //Create Http Client
    private var httpClient = HttpBaseClient().httpClient

    override suspend fun fetchPhotos(): Either<CustomException, List<PhotoResponse>?>? {
        return try {
            val response: List<PhotoResponse>? = httpClient.get(EndpointConfig.PHOTOS_SEARCH_URL)
            {
                parameter(METHOD, "flickr.photos.search")
                parameter(TAGS, "Electrolux")
            }
                .body<PhotosResponseWrapper>().photos?.photo?.filter { photoItem -> !photoItem.url.isNullOrEmpty() }
            Success(response)
        } catch (e: Exception) {
            Failure(e as CustomException)
        }
    }

}