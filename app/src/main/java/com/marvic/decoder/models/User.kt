package com.marvic.decoder.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.marvic.decoder.models.enums.diabetes.DiabetesType
import com.marvic.decoder.models.enums.hypertension.HypertensionType

@Entity(tableName = "users")
data class User(
    @ColumnInfo
    val name: String = "",
    @ColumnInfo
    val age: Int = 0,
    @ColumnInfo
    val diabetes: Boolean = false,
    @ColumnInfo
    val hypertension: Boolean = false,
    @ColumnInfo
    val diabetesType: DiabetesType = DiabetesType.NONE,
    @ColumnInfo
    val hypertensionType: HypertensionType = HypertensionType.NONE,
)
