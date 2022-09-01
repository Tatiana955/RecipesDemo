package com.example.recipesdemo.data.models.local.realms

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.realmListOf

open class RecipeRealm: RealmObject {
    @PrimaryKey
    var primaryKey: String? = ""
    var uri: String? = ""
    var label: String? = ""
    var labelForSearch: String? = ""
    var image: String? = ""
    var source: String? = ""
    var url: String? = ""
    var shareAs: String? = ""
    var yield: Int? = null
    var dietLabels: RealmList<String> = realmListOf()
    var healthLabels: RealmList<String> = realmListOf()
    var cautions: RealmList<String> = realmListOf()
    var ingredientLines: RealmList<String> = realmListOf()
    var ingredients: RealmList<IngredientsRealm>? = realmListOf()
    var calories: Double? = null
    var totalWeight: Double? = null
    var cuisineType: RealmList<String> = realmListOf()
    var mealType: RealmList<String> = realmListOf()
    var dishType: RealmList<String> = realmListOf()
    var totalNutrients: NutrientsRealm? = null
    var totalDaily: NutrientsRealm? = null
    var digest: RealmList<DigestRealm>? = realmListOf()
}






