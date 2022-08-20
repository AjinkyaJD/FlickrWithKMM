package com.ajinkyad.flickrelectrolux.di

import com.ajinkyad.flickrelectrolux.data.remote.services.FlickrImageServiceImpl
import com.ajinkyad.flickrelectrolux.shared.HttpBaseClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val baseClient = "BaseClient"
const val flickrImageService = "flickrImageService"

val imagesModule = module {
    single {
        FlickrImageServiceImpl(get(named(baseClient)))
    }
    single(named(baseClient)) {
        HttpBaseClient().httpClient
    }
}