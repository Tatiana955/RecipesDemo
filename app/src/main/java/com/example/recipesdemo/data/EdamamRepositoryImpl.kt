package com.example.recipesdemo.data

import com.example.recipesdemo.BuildConfig
import com.example.recipesdemo.util.Resource
import com.example.recipesdemo.data.models.remote.responses.Edamam
import com.example.recipesdemo.data.models.EdamamRepository
import com.example.recipesdemo.data.models.local.*
import com.example.recipesdemo.data.models.local.realms.RecipeRealm
import com.example.recipesdemo.data.models.remote.responses.Hit
import com.example.recipesdemo.data.models.remote.responses.Recipe
import com.example.recipesdemo.data.models.remote.EdamamApiService
import io.realm.RealmResults
import io.realm.toRealmList
import javax.inject.Inject

class EdamamRepositoryImpl @Inject constructor(
    private val api: EdamamApiService,
    private val database: RecipeDatabaseOperations
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

    override fun insertRecipe(recipe: Recipe) {
        val recipeRealm = RecipeRealm().apply {
            primaryKey = recipe.uri.drop(51)
            uri = recipe.uri
            label = recipe.label
            labelForSearch = recipe.label.lowercase()
            image = recipe.image
            source = recipe.source
            url = recipe.url
            shareAs = recipe.shareAs
            `yield` = recipe.yield
            dietLabels = recipe.dietLabels.toRealmList()
            healthLabels = recipe.healthLabels.toRealmList()
            cautions = recipe.cautions.toRealmList()
            ingredientLines = recipe.ingredientLines.toRealmList()
            ingredients.apply { recipe.ingredients }
            calories = recipe.calories
            totalWeight = recipe.totalWeight
            cuisineType = recipe.cuisineType.toRealmList()
            mealType = recipe.mealType.toRealmList()
            dishType = recipe.dishType.toRealmList()
            totalNutrients.apply { recipe.totalNutrients }
            totalDaily.apply { recipe.totalDaily }
            digest.apply { recipe.digest }
        }
        database.insertRecipe(recipeRealm)
    }

    override fun deleteRecipe(recipe: Recipe) {
        database.deleteRecipe(recipe)
    }

    override fun getRecipes(): RealmResults<RecipeRealm> {
        return database.getRecipes()
    }

    override fun findRecipe(q: String): RealmResults<RecipeRealm> {
        return database.findRecipe(q)
    }

    override fun getRecipeByPrimaryKey(primaryKey: String): RecipeRealm? {
        return database.getRecipeByPrimaryKey(primaryKey)
    }

    override fun deleteSelectedRecipes(listPrimaryKey: List<String>) {
        database.deleteSelectedRecipes(listPrimaryKey)
    }
}