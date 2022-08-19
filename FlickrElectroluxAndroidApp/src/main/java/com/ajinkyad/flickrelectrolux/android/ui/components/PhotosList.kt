package com.ajinkyad.flickrelectrolux.android.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import com.ajinkyad.flickrelectrolux.android.PhotosViewModel
import com.ajinkyad.flickrelectrolux.data.remote.dto.PhotoResponse
import com.ajinkyad.flickrelectrolux.domain.entity.Photo

@Composable
fun renderPhotoList(photosViewModel: PhotosViewModel) {
    val photos: List<Photo> by photosViewModel.photos.observeAsState(ArrayList())
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        items(photos) { photoItem ->
            renderPhotoCard(photoItem = photoItem)
        }
    }

}