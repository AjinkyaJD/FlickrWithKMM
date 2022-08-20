package com.ajinkyad.flickrelectrolux.android.di

import com.ajinkyad.flickrelectrolux.android.PhotosViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val androidModule = module {
    singleOf(::PhotosViewModel)
}