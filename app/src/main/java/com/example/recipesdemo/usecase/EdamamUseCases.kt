package com.example.recipesdemo.usecase

import javax.inject.Inject

data class EdamamUseCases @Inject constructor(
    val getRecipe: GetRecipe,
    val getRecipeById: GetRecipeById
)