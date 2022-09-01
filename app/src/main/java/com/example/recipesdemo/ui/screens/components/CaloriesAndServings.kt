package com.example.recipesdemo.ui.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun CaloriesAndServings(
    count: Int,
    text: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$count",
            style = MaterialTheme.typography.h5
        )
        Text(
            text = text,
            style = MaterialTheme.typography.body1
        )
    }
}