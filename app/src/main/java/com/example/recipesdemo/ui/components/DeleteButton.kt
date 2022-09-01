package com.example.recipesdemo.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.recipesdemo.R
import com.example.recipesdemo.util.State

@Composable
fun DeleteButton(
    modifier: Modifier,
    visibility: Boolean,
    hideButton: (Boolean) -> Unit = {},
    deleteSavedRecipe: () -> Unit,
    state: (State) -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Bottom
    ) {
        AnimatedVisibility(
            visible = visibility,
            enter = fadeIn(animationSpec = tween(500)),
            exit = fadeOut(animationSpec = tween(500))
        ) {
            FloatingActionButton(
                modifier = modifier
                    .padding(dimensionResource(R.dimen.padding_6)),
                onClick = {
                    deleteSavedRecipe()
                    hideButton(false)
                    state(State.IDLE)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = stringResource(R.string.delete)
                )
            }
        }
    }
}