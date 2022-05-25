package com.example.recipesdemo.data.models.local.realms

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class DigestRealm: RealmObject {
    var label: String? = ""
    @PrimaryKey
    var tag: String? = ""
    var total: Double? = null
    var daily: Double? = null
    var unit: String? = ""
    var sub: RealmList<SubRealm>? = null
}