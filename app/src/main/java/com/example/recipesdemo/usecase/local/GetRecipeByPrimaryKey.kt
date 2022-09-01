package com.example.recipesdemo.usecase.local

import com.example.recipesdemo.data.models.EdamamRepository
import com.example.recipesdemo.data.models.local.realms.RecipeRealm
import javax.inject.Inject

class GetRecipeByPrimaryKey @Inject constructor(
    private val repository: EdamamRepository
) {

    operator fun invoke(primaryKey: String): RecipeRealm? {
        return repository.getRecipeByPrimaryKey(primaryKey)
    }
}