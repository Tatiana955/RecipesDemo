package com.example.recipesdemo.data.models.local.realms

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class IngredientsRealm: RealmObject {
    var text: String? = ""
    var quantity: Double? = null
    var measure: String? = null
    var food: String? = ""
    var weight: Double? = null
    @PrimaryKey
    var foodId: String? = ""
}