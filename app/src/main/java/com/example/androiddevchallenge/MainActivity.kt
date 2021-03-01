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

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.data.Pet
import com.example.androiddevchallenge.ui.data.petData
import com.example.androiddevchallenge.ui.style.ContentText
import com.example.androiddevchallenge.ui.style.HeaderText
import com.example.androiddevchallenge.ui.style.TitleText
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                window.statusBarColor = Color(0xFF5C5E5E).toArgb()
                MyApp()
            }
        }
    }
}

// Start building your app here!
@ExperimentalFoundationApi
@Composable
fun MyApp() {
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            Spacer(modifier = Modifier.size(48.dp))
            HeaderText(name = "Welcome")
            TitleText(
                name = "Generous People",
                modifier = Modifier.padding(14.dp, 0.dp)
            )
            ContentText(
                text = "Start choose pet to adopt",
                modifier = Modifier.padding(14.dp, 0.dp), 1
            )
            Spacer(modifier = Modifier.size(18.dp))
            GetPetData(petList = petData())
        }
    }
}

@ExperimentalFoundationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@ExperimentalFoundationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

@Composable
fun PetCard(pet: Pet, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        contentColorFor(backgroundColor = MaterialTheme.colors.primary),
        elevation = 10.dp, border = BorderStroke(1.dp, Color.Gray)
    ) {
        Column(
            modifier = Modifier
                .clickable(onClick = onClick)
                .fillMaxWidth()
        ) {
            Box {
                CoilImage(
                    data = pet.image,
                    contentDescription = pet.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(125.dp),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = painterResource(
                        if (pet.isMale) R.drawable.ic_round_male_24
                        else R.drawable.ic_round_female_24
                    ),
                    "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(10.dp),
                    alignment = Alignment.Center
                )
            }

            Spacer(modifier = Modifier.size(10.dp))
            TitleText(name = pet.name, modifier = Modifier.padding(8.dp, 0.dp))
            ContentText(text = pet.type, modifier = Modifier.padding(8.dp, 0.dp), 1)
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun GetPetData(petList: List<Pet>) {
    val listState = rememberLazyListState()
    // Remember a CoroutineScope to be able to launch
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    LazyVerticalGrid(
        cells = GridCells.Fixed(2), state = listState,
        modifier = Modifier.padding(8.dp)
    ) {
        items(items = petList) { pet ->
            PetCard(
                pet = pet,
                onClick = {
                    coroutineScope.launch {
                        val intent = Intent(context, DetailActivity::class.java)
                        intent.putExtra(DetailActivity.DATA, pet)
                        context.startActivity(intent)
                    }
                }
            )
        }
    }
}
