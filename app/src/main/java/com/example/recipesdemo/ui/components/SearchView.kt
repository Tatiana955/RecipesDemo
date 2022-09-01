package com.example.recipesdemo.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import com.example.recipesdemo.R

@Composable
fun SearchView(
    modifier: Modifier,
    state: MutableState<TextFieldValue>,
    onSearch: () -> Unit,
    onReturn: () -> Unit = {}
) {
    val focusManager = LocalFocusManager.current
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = modifier
            .fillMaxWidth(),
        textStyle = MaterialTheme.typography.h4,
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = stringResource(R.string.search),
                modifier = modifier
                    .padding(dimensionResource(R.dimen.icon_paging_15))
                    .size(dimensionResource(R.dimen.icon_size_24))
            )
        },
        trailingIcon = {
            if (state.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        state.value = TextFieldValue("")
                        onReturn()
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = stringResource(R.string.close),
                        modifier = modifier
                            .padding(dimensionResource(R.dimen.icon_paging_15))
                            .size(dimensionResource(R.dimen.icon_size_24))
                    )
                }
            }
        },
        keyboardActions = KeyboardActions(
            onDone = {
                onSearch()
                focusManager.clearFocus()
            }
        ),
        singleLine = true,
        shape = RectangleShape,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor = Color.White,
            backgroundColor = MaterialTheme.colors.primary,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}