package com.example.recipesdemo.data.models.responses

import kotlinx.serialization.Serializable

@Serializable
data class Links(
    val self: Self?,
    val next: Next?
)

@Serializable
data class Self(
    val href: String,
    val title: String
)

@Serializable
data class Next(
    val href: String,
    val title: String
)