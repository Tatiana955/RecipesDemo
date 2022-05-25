package com.example.recipesdemo.usecase

import com.example.recipesdemo.usecase.local.*
import com.example.recipesdemo.usecase.remote.*
import javax.inject.Inject

data class EdamamUseCases @Inject constructor(
    val getRecipe: GetRecipe,
    val getRecipeById: GetRecipeById,
    val getRecipes: GetRecipes,
    val insertRecipe: InsertRecipe,
    val deleteRecipe: DeleteRecipe
)