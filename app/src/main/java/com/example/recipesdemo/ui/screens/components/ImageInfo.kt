package com.example.recipesdemo.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import coil.compose.rememberImagePainter
import com.example.recipesdemo.R

@Composable
fun ImageInfo(
    modifier: Modifier,
    image: String,
    size: Dp
) {
    Image(
        rememberImagePainter(
            data = image
        ),
        contentDescription = stringResource(R.string.image),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(size)
            .clip(
                RoundedCornerShape(
                    corner = CornerSize(dimensionResource(R.dimen.corner_size_16))
                )
            )
    )
}