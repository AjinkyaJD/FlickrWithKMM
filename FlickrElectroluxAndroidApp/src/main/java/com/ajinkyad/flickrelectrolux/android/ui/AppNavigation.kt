package com.ajinkyad.flickrelectrolux.android.ui

import android.graphics.drawable.Drawable
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ajinkyad.flickrelectrolux.android.PhotosViewModel
import com.ajinkyad.flickrelectrolux.android.ui.components.RenderPhotoList
import com.ajinkyad.flickrelectrolux.android.ui.components.ShowPhotoDetails

/**
 * Destinations used in the App.
 */
private object AppDestinations {
    const val PHOTOS_LIST_ROUTE = "photos_list"
    const val PHOTO_DETAILS_ROUTE = "photo_details"
}

@Composable
fun AppNavigation(
    startDestination: String = AppDestinations.PHOTOS_LIST_ROUTE,
    photosViewModel: PhotosViewModel
) {
    val navController = rememberNavController()
    var photoDrawable: Drawable? = null

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            AppDestinations.PHOTOS_LIST_ROUTE
        ) {
            RenderPhotoList(photosViewModel) { imageDrawable: Drawable? ->
                photoDrawable = imageDrawable
                navController.navigate(AppDestinations.PHOTO_DETAILS_ROUTE)
            }
        }
        composable(
            AppDestinations.PHOTO_DETAILS_ROUTE,
        ) {
            ShowPhotoDetails(
                photoDrawable
            )
        }
    }
}