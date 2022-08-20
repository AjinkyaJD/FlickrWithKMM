package com.ajinkyad.flickrelectrolux.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ajinkyad.flickrelectrolux.android.PhotosViewModel

@Composable
fun searchInputField(photosViewModel: PhotosViewModel) {
    val query: String by photosViewModel.query.collectAsState()
    // Immediately update and keep track of query from text field changes.
    var showClearIcon by rememberSaveable { mutableStateOf(false) }

    if (query.isEmpty()) {
        showClearIcon = false
    } else if (query.isNotEmpty()) {
        showClearIcon = true
    }

    TextField(
        value = query,
        onValueChange = photosViewModel::updateQuery,
        leadingIcon =
        {
            Icon(
                imageVector = Icons.Rounded.Search,
                tint = MaterialTheme.colors.onBackground,
                contentDescription = "Search icon"
            )
        },
        trailingIcon =
        {
            if (showClearIcon) {
                IconButton(onClick = { photosViewModel.updateQuery("") }) {
                    Icon(
                        imageVector = Icons.Rounded.Clear,
                        tint = MaterialTheme.colors.onBackground,
                        contentDescription = "Clear icon"
                    )
                }
            }
        },
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        placeholder =
        { Text(text = "Ex. Electrolux") },
        textStyle = MaterialTheme.typography.subtitle1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(color = MaterialTheme.colors.background, shape = RectangleShape)
    )
}
