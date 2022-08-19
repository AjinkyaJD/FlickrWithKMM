package com.ajinkyad.flickrelectrolux.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajinkyad.flickrelectrolux.data.remote.dto.PhotoResponse
import com.ajinkyad.flickrelectrolux.data.remote.services.FlickrImageServiceImpl
import com.ajinkyad.flickrelectrolux.domain.entity.Photo
import kotlinx.coroutines.launch

class PhotosViewModel : ViewModel() {

    private var _photos: MutableLiveData<List<Photo>> = MutableLiveData(ArrayList())
    val photos: LiveData<List<Photo>> = _photos

    var imageApiService = FlickrImageServiceImpl()

    init {
        callPhotosList()
    }

    private fun setPhotosList(photos: List<Photo>?) {
        _photos.value = photos
    }

    private fun callPhotosList() {
        viewModelScope.launch {
            imageApiService.fetchPhotos()?.process(
                failed = {
                    setPhotosList(ArrayList())
                },
                succeeded = {
                    setPhotosList(it)
                }
            )
        }
    }

}