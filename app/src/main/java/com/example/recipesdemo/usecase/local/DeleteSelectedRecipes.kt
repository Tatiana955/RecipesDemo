package com.example.recipesdemo.usecase.local

import com.example.recipesdemo.data.models.EdamamRepository
import com.example.recipesdemo.data.models.local.realms.RecipeRealm
import io.realm.RealmResults
import javax.inject.Inject

class DeleteSelectedRecipes @Inject constructor(
    private val repository: EdamamRepository
) {

    operator fun invoke(listPrimaryKey: List<String>) {
        repository.deleteSelectedRecipes(listPrimaryKey)
    }
}