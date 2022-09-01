package com.example.recipesdemo.data.models.local

import android.util.Log
import com.example.recipesdemo.data.models.local.realms.RecipeRealm
import com.example.recipesdemo.data.models.remote.responses.Recipe
import io.realm.Realm
import io.realm.RealmResults
import io.realm.query
import javax.inject.Inject

class RecipeDatabaseOperations @Inject constructor(
    private val realm: Realm
    ) {

    fun insertRecipe(recipe: RecipeRealm) {
        realm.writeBlocking {
            try {
                this.copyToRealm(recipe)
            } catch (e: IllegalArgumentException) {
                Log.d("!!!", e.toString())
            }
        }
    }

    fun deleteRecipe(recipe: Recipe) {
        realm.writeBlocking {
            val recipeRealm: RecipeRealm? =
                this.query<RecipeRealm>("uri == $0", recipe.uri)
                    .first()
                    .find()
            if (recipeRealm != null) {
                this.delete(recipeRealm)
            }
        }
    }

    fun getRecipes(): RealmResults<RecipeRealm> {
        return realm.query<RecipeRealm>().find()
    }

    fun findRecipe(q: String): RealmResults<RecipeRealm> {
        return realm.query<RecipeRealm>("labelForSearch == $0", q).find()
    }

    fun getRecipeByPrimaryKey(primaryKey: String): RecipeRealm? {
        return realm.query<RecipeRealm>("primaryKey == $0", primaryKey).first().find()
    }

    fun deleteSelectedRecipes(listPrimaryKey: List<String>) {
        realm.writeBlocking {
            for (i in listPrimaryKey) {
                val recipeRealm: RecipeRealm? =
                    this.query<RecipeRealm>("primaryKey == $0", i)
                        .first()
                        .find()
                if (recipeRealm != null) {
                    this.delete(recipeRealm)
                }
            }
        }
    }
}