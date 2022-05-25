package com.example.recipesdemo.data.models.remote.responses

data class Edamam(
    val from: Int,
    val to: Int,
    val count: Int,
    val _links: Links,
    val hits: List<Hit>
)