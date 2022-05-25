package com.example.recipesdemo.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import com.example.recipesdemo.R

@Composable
fun SpacerApp(
    modifier: Modifier,
    width: Dp = dimensionResource(R.dimen.width_0),
    height: Dp = dimensionResource(R.dimen.width_0)
) {
    Spacer(
        modifier = modifier
            .width(width)
            .height(height)
    )
}