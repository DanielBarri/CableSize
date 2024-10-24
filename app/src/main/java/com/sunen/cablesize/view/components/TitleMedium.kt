package com.sunen.cablesize.view.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TitleMedium(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium
    )
}