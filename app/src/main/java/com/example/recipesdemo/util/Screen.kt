package com.example.recipesdemo.util

sealed class Screen(var route: String, var title: String) {
    object EdamamScreen : Screen("edamam","EdamamScreen")
    object InfoScreen : Screen("info", "InfoScreen")
}
