package com.example.appservicio.features.randomadvice.data.datasources.remote.mapper

import com.example.appservicio.features.randomadvice.data.datasources.remote.model.AdviceResponseDto
import com.example.appservicio.features.randomadvice.domain.entities.Advice

// En este se convierte datos de la API en algo que la app entienda.
// SE obtiene objeto DTO de internet. Se manda una entidad limpia lista para usarse.
fun AdviceResponseDto.toDomain(translatedAdvice: String): Advice {
    return Advice(
        id = this.slip.id,
        adviceEn = this.slip.advice,
        adviceEs = translatedAdvice
    )
}
