package com.marvic.decoder.models.enums.hypertension

enum class HypertensionType(val type: String, val description: String) {
    NONE(
        "Sin hipertensión",
        "Indica que la persona no presenta hipertensión."
    ),
    PRIMARY(
        "Primaria / esencial",
        "Hipertensión primaria o esencial, sin causa específica identificable"
    ),
    SECONDARY("Secundaria", "Hipertensión secundaria, con una causa específica identificable"),
    ISOLATED_SYSTOLIC(
        "Sistólica aislada",
        "Hipertensión sistólica aislada, donde solo la presión sistólica es alta"
    ),
    ISOLATED_DIASTOLIC(
        "Diastólica aislada",
        "Hipertensión diastólica aislada, donde solo la presión diastólica es alta"
    ),
    MALIGNANT(
        "Maligna / Acelerada",
        "Hipertensión maligna o acelerada, forma grave y rápida de hipertensión"
    )
}