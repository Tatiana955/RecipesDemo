package com.example.recipesdemo.data.models

import com.example.recipesdemo.data.models.responses.Hit
import com.example.recipesdemo.data.models.responses.Links

data class Edamam(
    val from: Int,
    val to: Int,
    val count: Int,
    val _links: Links,
    val hits: List<Hit>
)