package com.example.recipesdemo.ui.screens.savedrecipescreen

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recipesdemo.ui.screens.components.ImageInfo
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.TextFieldValue
import com.example.recipesdemo.R
import com.example.recipesdemo.ui.components.DeleteButton
import com.example.recipesdemo.ui.components.SearchView
import com.example.recipesdemo.ui.components.SpacerApp
import com.example.recipesdemo.util.State

@ExperimentalFoundationApi
@Composable
fun SavedRecipeScreen(
    modifier: Modifier = Modifier,
    onClickDetails: (String) -> Unit,
    viewModel: SavedRecipeViewModel = hiltViewModel()
) {
    viewModel.getRecipes()
    val data = viewModel.list.value
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    val q by remember { textState }
    var visible by remember { mutableStateOf(false) }
    var state: State = State.IDLE
    Box {
        Column(
            modifier = modifier
                .fillMaxHeight()
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                SearchView(
                    modifier = modifier,
                    state = textState,
                    onSearch = { viewModel.findRecipe(q.text.lowercase()) },
                    onReturn = { viewModel.getRecipes() }
                )
            }
            LazyVerticalGrid(
                cells = GridCells.Fixed(3),
                contentPadding = PaddingValues(dimensionResource(R.dimen.padding_8))
            ) {
                this.items(items = data!!, itemContent = { item ->
                    RecipeItem(
                        modifier = modifier,
                        image = item.image,
                        label = item.label,
                        prKey = item.primaryKey,
                        onClickDetails = onClickDetails,
                        isSelected = { prKey, isSelected ->
                            if (isSelected) {
                                visible = isSelected
                                viewModel.listPrKeys.add(prKey)
                            } else {
                                viewModel.listPrKeys.remove(prKey)
                                if (viewModel.listPrKeys.isEmpty()) {
                                    visible = isSelected
                                }
                            }
                        },
                        st = state
                    )
                })
            }
        }
        DeleteButton(
            modifier = modifier,
            visibility = visible,
            hideButton = { visible = it },
            deleteSavedRecipe = {
                viewModel.deleteSelectedRecipes()
            },
            state = {
                state = it
            }
        )
    }
}

@Composable
private fun RecipeItem(
    modifier: Modifier,
    image: String?,
    label: String?,
    prKey: String?,
    onClickDetails: (String) -> Unit,
    isSelected: (String, Boolean) -> Unit,
    st: State,
) {
    var state by remember { mutableStateOf(st) }
    val backgroundColor: Color by animateColorAsState(
        targetValue =
        when (state) {
            State.IDLE ->
                MaterialTheme.colors.background
            State.PRESSED ->
                MaterialTheme.colors.primary
        }
    )
    Column(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_6))
            .clip(RoundedCornerShape(dimensionResource(R.dimen.padding_8)))
            .background(backgroundColor)
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        state = when (state) {
                            State.IDLE -> {
                                isSelected(prKey!!, true)
                                State.PRESSED
                            }
                            State.PRESSED -> {
                                isSelected(prKey!!, false)
                                State.IDLE
                            }
                        }
                    },
                    onTap = {
                        onClickDetails(prKey!!)
                    }
                )
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        image?.let {
            ImageInfo(
                modifier = modifier
                    .padding(top = dimensionResource(R.dimen.padding_4)),
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