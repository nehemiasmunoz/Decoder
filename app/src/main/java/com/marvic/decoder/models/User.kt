package com.marvic.decoder.models

import com.marvic.decoder.models.enums.diabetes.DiabetesType
import com.marvic.decoder.models.enums.hypertension.HypertensionType

data class User(
    val name: String = "",
    val age: Int = 0,
    val diabetes: Boolean = false,
    val hypertension: Boolean = false,
    val diabetesType: DiabetesType = DiabetesType.NONE,
    val hypertensionType: HypertensionType = HypertensionType.NONE,
    val preferences: String = "",
)
