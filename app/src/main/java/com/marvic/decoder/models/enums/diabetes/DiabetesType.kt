package com.marvic.decoder.models.enums.diabetes

enum class DiabetesType(val type: String, val description: String) {
    TYPE_1(
        "Diabetes tipo 1",
        "Enfermedad autoinmune en la que el sistema inmunológico ataca y destruye las células beta del páncreas que producen insulina."
    ),
    TYPE_2(
        "Diabetes tipo 2",
        "Forma más común de diabetes, caracterizada por la resistencia a la insulina y una disminución en la producción de insulina."
    ),
    GESTATIONAL(
        "Diabetes gestacional",
        "Ocurre durante el embarazo y generalmente desaparece después del parto."
    ),
    MONOGENIC(
        "Diabetes monogénica",
        "Causada por mutaciones en un solo gen, incluye formas como la diabetes neonatal y la diabetes MODY."
    ),
    SECONDARY(
        "Diabetes secundaria",
        "Resulta de otras condiciones médicas o tratamientos, como enfermedades pancreáticas, ciertos medicamentos o tratamientos hormonales."
    )

}