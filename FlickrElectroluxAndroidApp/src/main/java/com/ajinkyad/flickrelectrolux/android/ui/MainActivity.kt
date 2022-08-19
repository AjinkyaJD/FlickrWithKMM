package com.ajinkyad.flickrelectrolux.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ajinkyad.flickrelectrolux.android.PhotosViewModel
import com.google.android.material.composethemeadapter.MdcTheme

class MainActivity : ComponentActivity() {

    private var photosViewModel = PhotosViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MdcTheme {
                AppNavigation(photosViewModel = photosViewModel)
            }
        }
    }
}
