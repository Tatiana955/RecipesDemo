package com.example.recipesdemo.data.models.remote.responses

import kotlinx.serialization.Serializable

@Serializable
data class Sub(
    val label: String,
    val tag: String,
    val schemaOrgTag: String?,
    val total: Double,
    val hasRDI: Boolean,
    val daily: Double,
    val unit: String
)