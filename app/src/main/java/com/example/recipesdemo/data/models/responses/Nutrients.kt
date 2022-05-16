package com.example.recipesdemo.data.models.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Nutrients(
    @SerialName("SUGAR.added")
    val SUGAR_added: Nutrient? = null,
    val CA: Nutrient? = null,
    @SerialName("CHOCDF.net")
    val CHOCDF_net: Nutrient? = null,
    val CHOCDF: Nutrient? = null,
    val CHOLE: Nutrient? = null,
    val ENERC_KCAL: Nutrient? = null,
    val FAMS: Nutrient? = null,
    val FAPU: Nutrient? = null,
    val FASAT: Nutrient? = null,
    val FATRN: Nutrient? = null,
    val FIBTG: Nutrient? = null,
    val FOLDFE: Nutrient? = null,
    val FOLFD: Nutrient? = null,
    val FOLAC: Nutrient? = null,
    val FE: Nutrient? = null,
    val MG: Nutrient? = null,
    val NIA: Nutrient? = null,
    val P: Nutrient? = null,
    val K: Nutrient? = null,
    val PROCNT: Nutrient? = null,
    val RIBF: Nutrient? = null,
    val NA: Nutrient? = null,
    @SerialName("Sugar.alcohol")
    val Sugar_alcohol: Nutrient? = null,
    val SUGAR: Nutrient? = null,
    val THIA: Nutrient? = null,
    val FAT: Nutrient? = null,
    val VITA_RAE: Nutrient? = null,
    val VITB12: Nutrient? = null,
    val VITB6A: Nutrient? = null,
    val VITC: Nutrient? = null,
    val VITD: Nutrient? = null,
    val TOCPHA: Nutrient? = null,
    val VITK1: Nutrient? = null,
    val WATER: Nutrient? = null,
    val ZN: Nutrient? = null
)