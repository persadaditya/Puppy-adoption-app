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

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.androiddevchallenge.ui.style.TitleContentText
import com.example.androiddevchallenge.ui.style.TitleText
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

class DetailActivity : AppCompatActivity() {

    companion object {
        const val DATA = "dataKey"
    }

    private lateinit var pet: Pet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyTheme {
                // A surface container using the 'background' color from the theme
                pet = intent.getParcelableExtra(DATA)!!
                window.statusBarColor = Color(0xFF9A9C9C).toArgb()

                MyDetailApp(pet)
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyDetailApp(pet: Pet) {
    Scaffold {

        val context = LocalContext.current as Activity

        Column(modifier = Modifier.padding(it)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                CoilImage(
                    data = pet.image,
                    contentDescription = pet.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .size(72.dp)
                        .padding(16.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF9A9C9C))
                        .clickable { context.onBackPressed() }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                        contentDescription = "Back Button",
                        modifier =
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(4.dp),
                        alignment = Alignment.Center
                    )
                }
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .scrollable(orientation = Orientation.Vertical, state = rememberScrollState())
            ) {

                Spacer(modifier = Modifier.size(14.dp))
                Row {
                    HeaderText(name = pet.name)
                    Image(
                        painter = painterResource(
                            if (pet.isMale) R.drawable.ic_round_male_24
                            else R.drawable.ic_round_female_24
                        ),
                        contentDescription = "isMale",
                        modifier = Modifier.size(24.dp)
                    )
                }

                TitleText(
                    name = pet.type,
                    modifier = Modifier.padding(16.dp, 0.dp)
                )
                Row(modifier = Modifier.padding(16.dp, 0.dp)) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(0.dp, 4.dp)
                    ) {
                        TitleContentText(text = "COAT")
                        ContentText(
                            text = pet.coat,
                            modifier = Modifier
                                .fillMaxWidth(),
                            maxLines = 2
                        )
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(0.dp, 4.dp)
                    ) {
                        TitleContentText(text = "COLOR")
                        ContentText(
                            text = pet.color,
                            modifier = Modifier
                                .fillMaxWidth(),
                            maxLines = 2
                        )
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(0.dp, 4.dp)
                    ) {
                        TitleContentText(text = "SIZE")
                        ContentText(
                            text = pet.size,
                            modifier = Modifier
                                .fillMaxWidth(),
                            maxLines = 2
                        )
                    }
                }
                Spacer(modifier = Modifier.size(18.dp))
                ContentText(
                    text = pet.description,
                    modifier = Modifier.padding(16.dp, 0.dp), 14
                )
                Spacer(modifier = Modifier.size(18.dp))
            }
            Button(
                onClick = {
                    Toast.makeText(context, "${pet.name} Adopted", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Adopt ${pet.name}")
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightDetailPreview() {
    val previewPetData = petData()[5] // use for preview only
    MyTheme {
        MyDetailApp(previewPetData)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkDetailPreview() {
    val previewPetData = petData()[5] // use for preview only
    MyTheme(darkTheme = true) {
        MyDetailApp(previewPetData)
    }
}
