package com.example.recipesdemo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.recipesdemo.R
import com.example.recipesdemo.util.Constants.DRAWER_LIST
import com.example.recipesdemo.util.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppDrawer(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState,
    navController: NavController
) {
    val scope = rememberCoroutineScope()
    Box {
        Content(
            modifier = modifier,
            scaffoldState = scaffoldState,
            navController = navController,
            scope = scope
        )
    }
}

@Composable
private fun Content(
    modifier: Modifier,
    scaffoldState: ScaffoldState,
    navController: NavController,
    scope: CoroutineScope
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Header(
            modifier = modifier
        )
        SpacerApp(
            modifier = modifier,
            height = dimensionResource(R.dimen.height_4)
        )
        ListForDrawer(
            modifier = modifier,
            scope = scope,
            scaffoldState = scaffoldState,
            navController = navController
        )
    }
}

@Composable
private fun Header(
    modifier: Modifier
) {
    val list = listOf(
        R.drawable.picture_2,
        R.drawable.picture_1,
        R.drawable.picture_3,
        R.drawable.picture_4,
        R.drawable.picture_5
    )
    LazyRow {
        this.items(items = list, itemContent = { item ->
            PainterImage(
                modifier = modifier
                    .height(dimensionResource(R.dimen.height_100))
                    .padding(dimensionResource(R.dimen.padding_4)),
                id = item,
                description = stringResource(R.string.food_bank)
            )
        })
    }
}

@Composable
private fun ListForDrawer(
    modifier: Modifier,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavController,
) {
    val items = DRAWER_LIST
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    items.forEach { screen ->
        DrawerItem(
            modifier = modifier,
            screen = screen,
            selected = currentRoute == screen.route,
            onItemClick = {
                navController.navigate(screen.route) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }
        )
    }
}

@Composable
private fun DrawerItem(
    modifier: Modifier,
    screen: Screen,
    selected: Boolean,
    onItemClick: (Screen) -> Unit
) {
    val background =
        if (selected)
            MaterialTheme.colors.primaryVariant
        else
            MaterialTheme.colors.primary
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                onClick = { onItemClick(screen) }
            )
            .background(background)
            .padding(dimensionResource(R.dimen.padding_10))
    ) {
        PainterImage(
            modifier = modifier,
            id = screen.icon!!,
            description = screen.title,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary),
            contentScale = ContentScale.Inside
        )
        SpacerApp(
            modifier = modifier,
            width = dimensionResource(R.dimen.width_6)
        )
        Text(
            text = screen.title,
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Composable
private fun PainterImage(
    modifier: Modifier,
    id: Int,
    description: String,
    colorFilter: ColorFilter? = null,
    contentScale: ContentScale = ContentScale.Fit
) {
    Image(
        painter = painterResource(
            id = id
        ),
        contentDescription = description,
        modifier = modifier,
        colorFilter = colorFilter,
        contentScale = contentScale
    )
}