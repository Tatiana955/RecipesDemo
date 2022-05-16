package com.example.recipesdemo.data

import com.example.recipesdemo.BuildConfig
import com.example.recipesdemo.util.Resource
import com.example.recipesdemo.data.models.Edamam
import com.example.recipesdemo.data.models.responses.Hit
import com.example.recipesdemo.data.remote.EdamamApiService
import javax.inject.Inject

class EdamamRepositoryImpl @Inject constructor(
    private val api: EdamamApiService
    ): EdamamRepository {

    override suspend fun getRecipe(q: String): Resource<Edamam> {
        val edamam = api.getItem(
            BuildConfig.TYPE,
            q,
            BuildConfig.APP_ID,
            BuildConfig.APP_KEY
        )
        return if (edamam != null) {
            Resource.Success(edamam)
        } else {
            Resource.Error("An unknown error has occurred.")
        }
    }

    override suspend fun getRecipeById(id: String): Resource<Hit> {
        val hit = api.getItemById(
            id,
            BuildConfig.TYPE,
            BuildConfig.APP_ID,
            BuildConfig.APP_KEY)
        return if (hit != null) {
            Resource.Success(hit)
        } else {
            Resource.Error("An unknown error has occurred.")
        }
    }
}