package com.gopro.galary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageList = listOf(
            "https://picsum.photos/200/300",
            "https://picsum.photos/300/300",
            "https://picsum.photos/400/300",
            "https://picsum.photos/500/300"
        )
        setContent {
            MaterialTheme {
                GalleryGrid(images = imageList)
            }
        }
    }
}

@Composable
fun GalleryGrid(images: List<String>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(images) { imageUrl ->
            Image(
                painter = rememberAsyncImagePainter(imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1f)
                    .fillMaxWidth()
            )
        }
    }
}
