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
package com.example.androiddevchallenge.ui.style

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HeaderText(name: String) {
    Text(
        text = name, modifier = Modifier.padding(14.dp, 0.dp),
        fontWeight = FontWeight.ExtraBold,
        style = MaterialTheme.typography.h4
    )
}

@Composable
fun TitleText(name: String, modifier: Modifier) {
    Text(
        text = name,
        fontWeight = FontWeight.ExtraBold,
        style = MaterialTheme.typography.h6, modifier = modifier
    )
}

@Composable
fun ContentText(text: String, modifier: Modifier, maxLines: Int) {
    Text(
        text = text,
        fontWeight = FontWeight.Light,
        style = MaterialTheme.typography.subtitle2,
        maxLines = maxLines, modifier = modifier
    )
}

@Composable
fun TitleContentText(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.subtitle1
    )
}
