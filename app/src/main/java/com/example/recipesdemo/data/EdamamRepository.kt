package com.example.recipesdemo.data

import com.example.recipesdemo.util.Resource
import com.example.recipesdemo.data.models.Edamam
import com.example.recipesdemo.data.models.responses.Hit
import com.example.recipesdemo.data.models.responses.Recipe

interface EdamamRepository {

    suspend fun getRecipe(q: String): Resource<Edamam>

    suspend fun getRecipeById(id: String): Resource<Hit>
}