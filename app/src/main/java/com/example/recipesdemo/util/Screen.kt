package com.example.recipesdemo.util

import com.example.recipesdemo.R

sealed class Screen(var route: String, var title: String, var icon: Int?) {
    object EdamamScreen : Screen("edamam","Search", R.drawable.ic_baseline_search_24)
    object InfoScreen : Screen("info", "InfoScreen", null)
    object SavedRecipeScreen : Screen("saved", "Saved Recipes", R.drawable.ic_baseline_assignment_24)
    object DetailsRecipeScreen : Screen("details", "DetailsRecipeScreen", null)
    object WebPagesScreen : Screen("web_pages", "WebPagesScreen", null)
}
