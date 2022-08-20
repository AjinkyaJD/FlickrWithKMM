package com.ajinkyad.flickrelectrolux.android.di

import com.ajinkyad.flickrelectrolux.android.PhotosViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

// Modules to be injected
val androidModule = module {
    singleOf(::PhotosViewModel)
}