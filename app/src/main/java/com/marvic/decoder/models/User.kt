package com.marvic.decoder.models

import com.marvic.decoder.models.enums.diabetes.DiabetesType
import com.marvic.decoder.models.enums.hypertension.HypertensionType

data class User(
    val name: String = "",
    val email: String = "",
    val age: Int = 1,
    val diabetes: Boolean = false,
    val hypertension: Boolean = false,
    val diabetesType: DiabetesType = DiabetesType.TYPE_1,
    val hypertensionType: HypertensionType = HypertensionType.PRIMARY,
    val preferences: String = "",
)
