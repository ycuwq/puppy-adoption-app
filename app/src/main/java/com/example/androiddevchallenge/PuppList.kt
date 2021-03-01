/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Puppy

@Composable
fun PuppyList(puppyList: List<Puppy>, onItemClick: (Puppy) -> Unit) {
    LazyColumn() {
        items(puppyList) {
            PuppyRow(puppy = it, onItemClick = onItemClick)
        }
    }
}

@Composable
fun PuppyRow(puppy: Puppy, onItemClick: (Puppy) -> Unit) {
    Row(modifier = Modifier.padding(16.dp).clickable { onItemClick(puppy) }, verticalAlignment = Alignment.CenterVertically) {
        val image = painterResource(id = puppy.images.first())
        Image(
            painter = image,
            contentDescription = puppy.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp, 100.dp)
                .clip(MaterialTheme.shapes.medium)
        )
        Column(Modifier.padding(start = 16.dp, end = 16.dp)) {
            Text(text = puppy.name, style = MaterialTheme.typography.body1)
            Text(text = "${puppy.sex.str} ${puppy.age}", style = MaterialTheme.typography.body2)
            Text(text = puppy.breed, style = MaterialTheme.typography.body2)
            Text(text = puppy.location, style = MaterialTheme.typography.body2)
        }
    }
    Divider(
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.1f),
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
    )
}
