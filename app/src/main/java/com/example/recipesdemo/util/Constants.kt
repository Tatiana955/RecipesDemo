package com.example.recipesdemo.util

import com.example.recipesdemo.data.models.local.realms.*

object Constants {
    const val BASE_URL = "https://api.edamam.com/"

    val REALM_SET = setOf(
        RecipeRealm::class,
        IngredientsRealm::class,
        NutrientRealm::class,
        NutrientsRealm::class,
        DigestRealm::class,
        SubRealm::class
    )

    val DRAWER_LIST = listOf(
        Screen.EdamamScreen,
        Screen.SavedRecipeScreen
    )
}