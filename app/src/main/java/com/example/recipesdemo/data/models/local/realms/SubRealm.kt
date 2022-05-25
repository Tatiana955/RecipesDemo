package com.example.recipesdemo.data.models.local.realms

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class SubRealm: RealmObject {
    var label: String? = ""
    @PrimaryKey
    var tag: String? = ""
    var total: Double? = null
    var daily: Double? = null
    var unit: String? = ""
}