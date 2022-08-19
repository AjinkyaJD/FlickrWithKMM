package com.ajinkyad.flickrelectrolux.android.ui.components

import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun ShowPhotoDetails(photoDrawable: Drawable?) {
    Image(
        rememberAsyncImagePainter(photoDrawable),
        contentDescription = "",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxSize()
    )
}