package com.example.recipesdemo.data.models.local.realms

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class NutrientsRealm: RealmObject {
    @PrimaryKey
    var id: Long = Math.random().toLong()
    var SUGAR_added: NutrientRealm? = null
    var CA: NutrientRealm? = null
    var CHOCDF_net: NutrientRealm? = null
    var CHOCDF: NutrientRealm? = null
    var CHOLE: NutrientRealm? = null
    var ENERC_KCAL: NutrientRealm? = null
    var FAMS: NutrientRealm? = null
    var FAPU: NutrientRealm? = null
    var FASAT: NutrientRealm? = null
    var FATRN: NutrientRealm? = null
    var FIBTG: NutrientRealm? = null
    var FOLDFE: NutrientRealm? = null
    var FOLFD: NutrientRealm? = null
    var FOLAC: NutrientRealm? = null
    var FE: NutrientRealm? = null
    var MG: NutrientRealm? = null
    var NIA: NutrientRealm? = null
    var P: NutrientRealm? = null
    var K: NutrientRealm? = null
    var PROCNT: NutrientRealm? = null
    var RIBF: NutrientRealm? = null
    var NA: NutrientRealm? = null
    var Sugar_alcohol: NutrientRealm? = null
    var SUGAR: NutrientRealm? = null
    var THIA: NutrientRealm? = null
    var FAT: NutrientRealm? = null
    var VITA_RAE: NutrientRealm? = null
    var VITB12: NutrientRealm? = null
    var VITB6A: NutrientRealm? = null
    var VITC: NutrientRealm? = null
    var VITD: NutrientRealm? = null
    var TOCPHA: NutrientRealm? = null
    var VITK1: NutrientRealm? = null
    var WATER: NutrientRealm? = null
    var ZN: NutrientRealm? = null
}