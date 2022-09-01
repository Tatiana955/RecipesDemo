package com.example.recipesdemo.ui.screens.edamamscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.recipesdemo.R
import com.example.recipesdemo.data.models.remote.responses.Hit
import com.example.recipesdemo.ui.components.HorizontalDivider
import com.example.recipesdemo.ui.components.SearchView
import com.example.recipesdemo.ui.components.SpacerApp
import com.example.recipesdemo.ui.screens.components.ImageInfo
import com.example.recipesdemo.ui.screens.components.LabelInfo
import kotlin.math.roundToInt

@Composable
fun EdamamScreen(
    modifier: Modifier = Modifier,
    viewModel: EdamamViewModel = hiltViewModel(),
    onItemClick: (String) -> Unit
) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    val q by remember { textState }
    val data by remember { viewModel.list }
    Box {
        Content(
            modifier = modifier,
            onItemClick = onItemClick,
            textState = textState,
            onSearch = { viewModel.getRecipe(q.text) },
            data = data
        )
    }
}

@Composable
private fun Content(
    modifier: Modifier,
    onItemClick: (String) -> Unit,
    textState: MutableState<TextFieldValue>,
    onSearch: () -> Unit,
    data: List<Hit>?
) {
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
        ) {
            SearchView(
                modifier = modifier,
                state = textState,
                onSearch = { onSearch() }
            )
        }
        ResultsList(
            modifier = modifier,
            onItemClick = onItemClick,
            data = data
        )
    }
}

@Composable
private fun ResultsList(
    modifier: Modifier,
    onItemClick: (String) -> Unit,
    data: List<Hit>?
) {
    LazyColumn {
        this.items(items = data!!, itemContent = { item ->
            ResultItem(
                modifier = modifier,
                label = item.recipe.label,
                image = item.recipe.image,
                id = item.recipe.uri.drop(51),
                calories = (item.recipe.calories / item.recipe.yield).roundToInt(),
                count = item.recipe.ingredients.size,
                onItemClick = onItemClick
            )
        })
    }
}

@Composable
private fun ResultItem(
    modifier: Modifier,
    label: String,
    image: String,
    id: String,
    calories: Int,
    count: Int,
    onItemClick: (String) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clickable(
                onClick = { onItemClick(id) }
            )
            .clip(RectangleShape)
            .padding(dimensionResource(R.dimen.padding_8))
    ) {
        ImageInfo(
            modifier = modifier,
            image = image,
            size = dimensionResource(R.dimen.image_size_400)
        )
        LabelInfo(
            modifier = modifier,
            label = label
        )
        HorizontalDivider(modifier = modifier)
        Row(
            modifier = modifier
                .wrapContentHeight()
                .height(IntrinsicSize.Min)
        ) {
            CaloriesAndIngredientsItem(
                modifier = modifier,
                count = calories,
                text = stringResource(R.string._calories)
            )
            SpacerApp(
                modifier = modifier,
                width = dimensionResource(R.dimen.width_20)
            )
            Divider(
                color = MaterialTheme.colors.primary,
                modifier = modifier
                    .fillMaxHeight()
                    .padding(
                        top = dimensionResource(R.dimen.padding_2),
                        bottom = dimensionResource(R.dimen.padding_2)
                    )
                    .width(dimensionResource(R.dimen.width_2))
            )
            SpacerApp(
                modifier = modifier,
                width = dimensionResource(R.dimen.width_20)
            )
            CaloriesAndIngredientsItem(
                modifier = modifier,
                count = count,
                text = stringResource(R.string._ingredients)
            )
        }
        HorizontalDivider(modifier = modifier)
    }
}

@Composable
private fun CaloriesAndIngredientsItem(
    modifier: Modifier,
    count: Int,
    text: String
) {
    Text(
        text = "$count",
        style = MaterialTheme.typography.h5
    )
    SpacerApp(
        modifier = modifier,
        width = dimensionResource(R.dimen.width_10)
    )
    Text(
        text = text,
        style = MaterialTheme.typography.h5
    )
}