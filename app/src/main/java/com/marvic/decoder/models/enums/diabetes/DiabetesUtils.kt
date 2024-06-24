package com.marvic.decoder.models.enums.diabetes

fun getDiabetesTypeList(): List<DiabetesType> {
    val diabetesTypeList = mutableListOf<DiabetesType>();
    diabetesTypeList.add(DiabetesType.TYPE_1)
    diabetesTypeList.add(DiabetesType.TYPE_2)
    diabetesTypeList.add(DiabetesType.SECONDARY)
    diabetesTypeList.add(DiabetesType.MONOGENIC)
    diabetesTypeList.add(DiabetesType.GESTATIONAL)
    return diabetesTypeList
}