package com.ajinkyad.flickrelectrolux.android.ui.components

import android.graphics.drawable.Drawable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ajinkyad.flickrelectrolux.android.PhotosViewModel
import com.ajinkyad.flickrelectrolux.domain.entity.Photo

@Composable
fun RenderPhotoList(photosViewModel: PhotosViewModel, tappedPhoto: (Drawable?) -> Unit) {
    val photos: List<Photo> by photosViewModel.photos.observeAsState(ArrayList())
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        searchInputField(photosViewModel = photosViewModel)
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            items(photos) { photoItem ->
                RenderPhotoCard(photoItem = photoItem, tappedPhoto = tappedPhoto)
            }
        }
    }

}