package com.ajinkyad.flickrelectrolux.android.ui.components

import android.graphics.drawable.Drawable
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.imageLoader
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Size
import com.ajinkyad.flickrelectrolux.domain.entity.Photo


@Composable
fun RenderPhotoCard(photoItem: Photo, tappedPhoto: (Drawable?) -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val context = LocalContext.current
        val imageLoader = context.imageLoader

        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(photoItem.url)
                .addHeader("Accept-Encoding", "keep-alive")
                .crossfade(true)
                .memoryCachePolicy(CachePolicy.ENABLED)
                .diskCachePolicy(CachePolicy.ENABLED)
                .diskCacheKey(photoItem.url)
                .memoryCacheKey(photoItem.url)
                .size(Size.ORIGINAL)
                .build(),
            contentDescription = null,
            placeholder = painterResource(id = com.ajinkyad.flickrelectrolux.android.R.drawable.placeholder_image),
            error = painterResource(id = com.ajinkyad.flickrelectrolux.android.R.drawable.error_image),
            contentScale = ContentScale.Crop,
            onLoading = {
                Log.e("ERR Loading - ", it.toString())
            },
            onError = {
                Log.e("ERR Error - ", it.result.throwable.toString())
            },
            modifier = Modifier
                .fillMaxSize()
                .clickable(onClick = {
                    getImagePathFromCache(
                        imageLoader,
                        photoItem,
                        tappedPhoto
                    )
                })
                .size(225.dp),
        )

    }
}

fun getImagePathFromCache(
    imageLoader: ImageLoader,
    photoItem: Photo,
    tappedPhoto: (Drawable?) -> Unit
) {
    // TODO - Handle better to make it fail safe
    val cachedImagePath = imageLoader.diskCache?.get(photoItem.url!!)
    val cachedImageDrawable = Drawable.createFromPath(cachedImagePath?.data.toString())
    return tappedPhoto(cachedImageDrawable)
}
