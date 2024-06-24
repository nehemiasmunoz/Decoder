package com.marvic.decoder.models

data class Ingredient(
    val id: Int,
    val name: String,
    val description: String,
    val recommendedForDiabetics: Boolean,
    val recommendedForHypertensives: Boolean,
    val diabeticReasons: String,
    val hypertensiveReasons: String,
    val nutritionalInfo: String,
)
