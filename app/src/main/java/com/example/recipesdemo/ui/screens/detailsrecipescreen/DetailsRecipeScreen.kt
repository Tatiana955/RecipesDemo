package com.example.recipesdemo.ui.screens.detailsrecipescreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recipesdemo.R
import com.example.recipesdemo.ui.screens.components.CaloriesAndServings
import com.example.recipesdemo.ui.components.HorizontalDivider
import com.example.recipesdemo.ui.screens.components.ImageInfo
import com.example.recipesdemo.ui.screens.components.LabelInfo
import io.realm.RealmList
import kotlin.math.roundToInt

@Composable
fun DetailsRecipeScreen(
    modifier: Modifier = Modifier,
    prKey: String?,
    onClickInfo: (String) -> Unit,
    onClickInstructions: (String) -> Unit,
    viewModel: DetailsRecipeViewModel = hiltViewModel()
) {
    viewModel.dataPrimaryKey.value = prKey!!
    viewModel.getRecipeByPrimaryKey()
    val data by remember { viewModel.recipe }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_4))
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            data?.let {
                Content(
                    modifier = modifier,
                    label = it.label!!,
                    image = it.image!!,
                    source = it.source!!,
                    calories = it.calories!!,
                    servings = it.yield!!,
                    ingredientLines = it.ingredientLines,
                    onClickInfo = { onClickInfo(it.uri!!.drop(51)) },
                    onClickInstructions = { onClickInstructions(it.primaryKey!!) }
                )
            }
        }
    }
}

@Composable
private fun Content(
    modifier: Modifier,
    label: String,
    image: String,
    source: String,
    calories: Double,
    servings: Int,
    ingredientLines: RealmList<String>,
    onClickInfo: () -> Unit,
    onClickInstructions: () -> Unit
) {
    LabelInfo(
        modifier = modifier
            .fillMaxWidth(),
        label = label
    )
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        ImageInfo(
            modifier = modifier
                .padding(dimensionResource(R.dimen.padding_4)),
            image = image,
            size = dimensionResource(R.dimen.image_size_200)
        )
        Column(
            modifier = modifier
                .padding(dimensionResource(R.dimen.padding_4)),
            verticalArrangement = Arrangement.Top
        ) {
            InfoAndInstructions(
                modifier = modifier,
                text = stringResource(R.string.see_info),
                onClick = { onClickInfo() }
            )
            InfoAndInstructions(
                modifier = modifier,
                text = stringResource(R.string.instructions) + ": $source",
                onClick = { onClickInstructions() }
            )
            HorizontalDivider(
                modifier = modifier
            )
            CaloriesAndServingsRow(
                modifier = modifier,
                text = stringResource(R.string._calories_serving),
                count = (calories.div(servings)).roundToInt()
            )
            CaloriesAndServingsRow(
                modifier = modifier,
                text = stringResource(R.string._servings),
                count = servings
            )
        }
    }
    Ingredients(
        modifier = modifier,
        ingredientLines = ingredientLines
    )
}

@Composable
private fun InfoAndInstructions(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit
) {
    HorizontalDivider(
        modifier = modifier
    )
    Text(
        text = text,
        style = MaterialTheme.typography.body1,
        modifier = modifier
            .clickable {
                onClick()
            }
    )
}

@Composable
private fun CaloriesAndServingsRow(
    modifier: Modifier,
    text: String,
    count: Int
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        CaloriesAndServings(
            count = count,
            text = text
        )
    }
    HorizontalDivider(
        modifier = modifier
    )
}

@Composable
private fun Ingredients(
    modifier: Modifier,
    ingredientLines: RealmList<String>
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "${ingredientLines.size} " + stringResource(R.string.ingredients),
            style = MaterialTheme.typography.h5
        )
    }
    HorizontalDivider(
        modifier = modifier
    )
    ingredientLines.forEach { ingredient ->
        Text(
            text = ingredient,
            style = MaterialTheme.typography.body1
        )
    }
    HorizontalDivider(
        modifier = modifier
    )
}