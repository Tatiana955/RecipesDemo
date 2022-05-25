package com.example.recipesdemo.data.models.local.realms

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class NutrientRealm: RealmObject {
    var uri: String? = null
    @PrimaryKey
    var label: String? = null
    var quantity: Float? = null
    var unit: String? = null
}