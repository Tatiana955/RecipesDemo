package com.example.recipesdemo.data.models

import com.example.recipesdemo.util.Resource
import com.example.recipesdemo.data.models.local.realms.RecipeRealm
import com.example.recipesdemo.data.models.remote.responses.Edamam
import com.example.recipesdemo.data.models.remote.responses.Hit
import com.example.recipesdemo.data.models.remote.responses.Recipe
import io.realm.RealmResults

interface EdamamRepository {

    suspend fun getRecipe(q: String): Resource<Edamam>

    suspend fun getRecipeById(id: String): Resource<Hit>

    fun insertRecipe(recipe: Recipe)

    fun deleteRecipe(recipe: Recipe)

    fun getRecipes(): RealmResults<RecipeRealm>
}