package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Puppy


@Composable
fun PuppyDetail(puppy: Puppy, onAdopt: (Puppy) -> Unit = {}) {
    val pageState = remember {
        PagerState().apply {
            minPage = 0
            maxPage = (puppy.images.size - 1).coerceAtLeast(0)
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondary)
            .verticalScroll(rememberScrollState())
    ) {
        Box {
            Pager(state = pageState, modifier = Modifier.aspectRatio(1f)) {
                Image(
                    bitmap = ImageBitmap.imageResource(id = puppy.images[page]),
                    contentDescription = "Dog picture: ${puppy.name}",
                    Modifier.aspectRatio(1f),
                    contentScale = ContentScale.Crop,
                )
            }
            Button(
                { onAdopt(puppy) },
                Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Text(text = "Adopt")
            }
        }
        Column(Modifier.padding(16.dp, 8.dp)) {
            Text("Name: ${puppy.name}", style = MaterialTheme.typography.h6)
            ProvideTextStyle(MaterialTheme.typography.body1) {
                Text("Breed: ${puppy.breed}")
                Text("Age: ${puppy.age}")
                Text("Sex: ${puppy.sex.str}")
                Text("Color: ${puppy.color}")
                Text("Location: ${puppy.location}")
            }
            Text(text = puppy.story, style = MaterialTheme.typography.body2)
        }
    }
}