package com.example.recipesdemo.data.models.remote.responses

import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    val uri: String,
    val label: String,
    val image: String,
    val images: Images,
    val source: String,
    val url: String,
    val shareAs: String,
    val yield: Int,
    val dietLabels: List<String>,
    val healthLabels: List<String>,
    val cautions: List<String>,
    val ingredientLines: List<String>,
    val ingredients: List<Ingredients>,
    val calories: Double,
    val glycemicIndex: Int,
    val totalCO2Emissions: Int,
    val co2EmissionsClass: String,
    val totalWeight: Double,
    val cuisineType: List<String>,
    val mealType: List<String>,
    val dishType: List<String>,
    val totalNutrients: Nutrients,
    val totalDaily: Nutrients,
    val digest: List<Digest>,
)