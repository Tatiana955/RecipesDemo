package com.example.recipesdemo.ui.screens.savedrecipescreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recipesdemo.ui.screens.components.ImageInfo
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.res.dimensionResource
import com.example.recipesdemo.R
import com.example.recipesdemo.ui.components.SpacerApp

@ExperimentalFoundationApi
@Composable
fun SavedRecipeScreen(
    modifier: Modifier = Modifier,
    viewModel: SavedRecipeViewModel = hiltViewModel()
) {
    viewModel.getRecipes()
    val data by remember { viewModel.list }

    Box {
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            contentPadding = PaddingValues(dimensionResource(R.dimen.padding_8))
        ) {
            this.items(items = data!!, itemContent = { item ->
                RecipeItem(
                    modifier = modifier,
                    image = item.image,
                    label = item.label
                )
            })
        }
    }
}

@Composable
private fun RecipeItem(
    modifier: Modifier,
    image: String?,
    label: String?
) {
    Column(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_6))
            .clip(RectangleShape),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        image?.let {
            ImageInfo(
                modifier = modifier,
                image = it,
                size = dimensionResource(R.dimen.image_size_84)
            )
        }
        SpacerApp(
            modifier = modifier,
            height = dimensionResource(R.dimen.padding_8)
        )
        label?.let {
            Text(
                modifier = modifier
                    .padding(dimensionResource(R.dimen.padding_2)),
                text = it,
                maxLines = 1,
                style = MaterialTheme.typography.caption
            )
        }
    }
}