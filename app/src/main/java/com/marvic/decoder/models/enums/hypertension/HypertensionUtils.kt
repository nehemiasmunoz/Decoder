package com.marvic.decoder.models.enums.hypertension


fun getHypertensionTypeList(): List<HypertensionType> {
    val hypertensionTypeList = mutableListOf<HypertensionType>()
    hypertensionTypeList.add(HypertensionType.PRIMARY)
    hypertensionTypeList.add(HypertensionType.SECONDARY)
    hypertensionTypeList.add(HypertensionType.ISOLATED_SYSTOLIC)
    hypertensionTypeList.add(HypertensionType.ISOLATED_DIASTOLIC)
    hypertensionTypeList.add(HypertensionType.MALIGNANT)
    return hypertensionTypeList
}