package com.example.recipesdemo.ui.screens.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.recipesdemo.R

@Composable
fun LabelInfo(
    modifier: Modifier,
    label: String
) {
    Row(
        modifier = modifier
            .wrapContentSize()
            .padding(
                vertical = dimensionResource(R.dimen.padding_8)
            )
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.h5
        )
    }
}