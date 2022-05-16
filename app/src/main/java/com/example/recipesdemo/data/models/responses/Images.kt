package com.example.recipesdemo.data.models.responses

import kotlinx.serialization.Serializable

@Serializable
data class Images(
    val THUMBNAIL: THUMBNAIL,
    val SMALL: SMALL,
    val REGULAR: REGULAR,
    val LARGE: LARGE
)

@Serializable
data class THUMBNAIL(
    val url: String,
    val width: Int,
    val height: Int
)

@Serializable
data class SMALL(
    val url: String,
    val width: Int,
    val height: Int
)

@Serializable
data class REGULAR(
    val url: String,
    val width: Int,
    val height: Int
)

@Serializable
data class LARGE(
    val url: String,
    val width: Int,
    val height: Int
)