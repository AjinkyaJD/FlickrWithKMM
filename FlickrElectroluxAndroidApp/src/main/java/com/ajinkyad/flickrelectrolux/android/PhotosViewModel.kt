package com.ajinkyad.flickrelectrolux.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajinkyad.flickrelectrolux.data.remote.services.FlickrImageServiceImpl
import com.ajinkyad.flickrelectrolux.domain.entity.Photo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

class PhotosViewModel : ViewModel() {
    private val _queryText = MutableStateFlow("")
    val query: StateFlow<String> = _queryText

    private var _photos: MutableLiveData<List<Photo>> = MutableLiveData(ArrayList())
    val photos: LiveData<List<Photo>> = _photos

    var imageApiService = FlickrImageServiceImpl()

    init {
        callPhotosList()
        viewModelScope.launch {
            _queryText.debounce(1500)
                .collect(::performQuery)
        }
    }

    fun updateQuery(query: String) {
        _queryText.value = query
    }

    private fun performQuery(
        query: String,
    ) {
        if (query.isNotEmpty()) {
            // Perform search
            callPhotosListWithTag(query)
        } else {
            callPhotosList()
        }
    }

    private fun setPhotosList(photos: List<Photo>?) {
        _photos.value = photos
    }

    private fun callPhotosListWithTag(query: String?) {
        viewModelScope.launch {
            imageApiService.fetchPhotos(query)?.process(
                failed = {
                    setPhotosList(ArrayList())
                },
                succeeded = {
                    setPhotosList(it)
                }
            )
        }
    }

    private fun callPhotosList() {
        callPhotosListWithTag(null)
    }

}