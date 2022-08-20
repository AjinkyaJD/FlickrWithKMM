package com.ajinkyad.flickrelectrolux.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ajinkyad.flickrelectrolux.android.PhotosViewModel
import com.google.android.material.composethemeadapter.MdcTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val photosViewModel: PhotosViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MdcTheme {
                AppNavigation(photosViewModel = photosViewModel)
            }
        }
    }
}
