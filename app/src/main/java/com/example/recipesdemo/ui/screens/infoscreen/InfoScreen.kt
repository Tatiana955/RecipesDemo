package com.example.recipesdemo.ui.screens.infoscreen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.toSize
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recipesdemo.R
import com.example.recipesdemo.data.models.responses.*
import com.example.recipesdemo.ui.components.HorizontalDivider
import com.example.recipesdemo.ui.screens.components.ImageInfo
import com.example.recipesdemo.ui.screens.components.LabelInfo
import kotlin.math.roundToInt

@Composable
fun InfoScreen(
    modifier: Modifier = Modifier,
    id: String?,
    viewModel: InfoViewModel = hiltViewModel()
) {
    viewModel.dataId.value = id!!
    val data by remember { viewModel.info }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(R.dimen.padding_20)
            )
            .verticalScroll(rememberScrollState())
    ) {
        Content(
            modifier = modifier,
            data = data
        )
    }
}

@Composable
private fun Content(
    modifier: Modifier,
    data: Recipe?
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        data?.let {
            LabelInfo(
                modifier = modifier,
                label = it.label
            )
            ImageInfo(
                modifier = modifier,
                image = it.image,
                size = dimensionResource(R.dimen.image_size_300)
            )
            DropdownListOfIngredients(
                modifier = modifier,
                ingredients = it.ingredients
            )
            Nutrition(
                modifier = modifier,
                data = it
            )
            DietAndHealthLabels(
                modifier = modifier,
                data = it
            )
            DigestList(
                modifier = modifier,
                recipe = it
            )
        }
    }
}

@Composable
private fun DropdownListOfIngredients(
    modifier: Modifier,
    ingredients: List<Ingredients>
) {
    var expanded by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(Size.Zero)}
    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown
    Column {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            label = {
                Text(
                    text = stringResource(R.string.ingredients),
                    style = MaterialTheme.typography.subtitle1
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = stringResource(R.string.arrow),
                    modifier = modifier
                        .clickable { expanded = !expanded },
                    tint = Color.White
                )
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = modifier
                .width(
                    with(LocalDensity.current) {
                        textFieldSize.width.toDp()
                    }
                )
                .background(MaterialTheme.colors.background)
        ) {
            ingredients.forEach { ingredient ->
                DropdownMenuItem(
                    onClick = { expanded = false }
                ) {
                    Text(
                        text = ingredient.text
                    )
                }
            }
        }
    }
}

@Composable
private fun Nutrition(
    modifier: Modifier,
    data: Recipe
) {
    Column {
        Text(
            text = stringResource(R.string.nutrition),
            modifier = modifier
                .padding(
                    vertical = dimensionResource(R.dimen.padding_10)
                )
                .align(Alignment.CenterHorizontally)
        )
        HorizontalDivider(modifier = modifier)
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CaloriesAndServings(
                count = (data.calories / data.yield).roundToInt(),
                text = stringResource(R.string._calories_serving)
            )
            CaloriesAndServings(
                count = data.yield,
                text = stringResource(R.string._servings)
            )
        }
        HorizontalDivider(modifier = modifier)
    }
}

@Composable
private fun CaloriesAndServings(
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

@Composable
private fun DietAndHealthLabels(
    modifier: Modifier,
    data: Recipe
) {
    val text = "${data.dietLabels}, ${data.healthLabels}"
        .replace("[","")
        .replace("]", "")
    Row(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_10))
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.body2
        )
    }
}

@Composable
private fun DigestList(
    modifier: Modifier,
    recipe: Recipe
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        DigestColumn(
            modifier = modifier,
            recipe = recipe,
            paddingStart = dimensionResource(R.dimen.padding_16),
            digest = { it.label },
            sub = { it.label }
        )
        DigestColumn(
            modifier = modifier,
            recipe = recipe,
            hA = Alignment.End,
            digest = { "${(it.total / recipe.yield).roundToInt()} ${it.unit}" },
            sub = { "${(it.total / recipe.yield).roundToInt()} ${it.unit}" }
        )
        DigestColumn(
            modifier = modifier,
            recipe = recipe,
            hA = Alignment.End,
            digest = { "${(it.daily / recipe.yield).roundToInt()}%" },
            sub = { "${(it.daily / recipe.yield).roundToInt()}%" }
        )
    }
}

@Composable
private fun DigestColumn(
    modifier: Modifier,
    recipe: Recipe,
    paddingStart: Dp = dimensionResource(R.dimen.padding_0),
    hA: Alignment.Horizontal = Alignment.Start,
    digest: (Digest) -> String,
    sub: (Sub) -> String
) {
    Column(
        horizontalAlignment = hA
    ) {
        recipe.digest.forEach { d ->
            DigestText(
                modifier = modifier,
                text = digest(d)
            )
            d.sub?.forEach { s ->
                DigestText(
                    modifier = modifier
                        .padding(start = paddingStart),
                    text = sub(s)
                )
            }
        }
    }
}

@Composable
private fun DigestText(
    modifier: Modifier,
    text: String
) {
    Text(
        modifier = modifier
            .padding(
                top = dimensionResource(R.dimen.padding_4)
            ),
        text = text,
        style = MaterialTheme.typography.subtitle2
    )
}