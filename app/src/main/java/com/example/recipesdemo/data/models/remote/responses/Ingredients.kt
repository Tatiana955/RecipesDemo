package com.example.recipesdemo.data.models.remote.responses

import kotlinx.serialization.Serializable

@Serializable
data class Ingredients(
    val text: String,
    val quantity: Double,
    val measure: String,
    val food: String,
    val weight: Double,
    val foodId: String
)