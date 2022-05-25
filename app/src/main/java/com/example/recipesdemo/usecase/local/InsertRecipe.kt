package com.example.recipesdemo.usecase.local

import com.example.recipesdemo.data.models.EdamamRepository
import com.example.recipesdemo.data.models.remote.responses.Recipe
import javax.inject.Inject

class InsertRecipe @Inject constructor(
    private val repository: EdamamRepository
) {

    operator fun invoke(recipe: Recipe) {
        repository.insertRecipe(recipe)
    }
}