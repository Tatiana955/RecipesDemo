package com.example.recipesdemo.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Burgundy500,
    primaryVariant = Burgundy700,
    secondary = Color.White,
    background = Burgundy200,
    surface = Burgundy500,
    onPrimary = Color.White,
    onSecondary = Burgundy500,
    onBackground = Color.White,
    onSurface = Color.White
)

private val LightColorPalette = lightColors(
    primary = Sandalwood500,
    primaryVariant = Sandalwood700,
    secondary = Color.White,
    background = Sandalwood200,
    surface = Sandalwood500,
    onPrimary = Color.White,
    onSecondary = Sandalwood500,
    onBackground = Color.White,
    onSurface = Color.White
)

@Composable
fun RecipesDemoTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}