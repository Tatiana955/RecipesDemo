package com.example.recipesdemo.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.recipesdemo.R

@Composable
fun HorizontalDivider(
    modifier: Modifier
) {
    Divider(
        color = MaterialTheme.colors.primary,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                vertical = dimensionResource(R.dimen.padding_4)
            ),
        thickness = dimensionResource(R.dimen.thickness_2)
    )
}