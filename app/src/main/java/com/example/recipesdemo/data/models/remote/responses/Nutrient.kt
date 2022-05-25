package com.example.recipesdemo.data.models.remote.responses

import kotlinx.serialization.Serializable

@Serializable
data class Nutrient(
    val uri: String,
    val label: String,
    val quantity: Float,
    val unit: String
)