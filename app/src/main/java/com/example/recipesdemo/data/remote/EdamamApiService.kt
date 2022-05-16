package com.example.recipesdemo.data.remote

import com.example.recipesdemo.data.models.Edamam
import com.example.recipesdemo.data.models.responses.Hit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EdamamApiService {

    @GET("api/recipes/v2")
    suspend fun getItem(
        @Query("type") type: String,
        @Query("q") q: String,
        @Query("app_id") app_id: String,
        @Query("app_key") app_key: String
    ): Edamam?

    @GET("api/recipes/v2/{id}")
    suspend fun getItemById(
        @Path("id") id: String,
        @Query("type") type: String,
        @Query("app_id") app_id: String,
        @Query("app_key") app_key: String
    ): Hit?
}