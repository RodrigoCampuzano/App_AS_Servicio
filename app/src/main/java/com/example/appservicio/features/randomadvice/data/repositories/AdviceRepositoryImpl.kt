package com.example.appservicio.features.randomadvice.data.repositories

import com.example.appservicio.core.network.AdviceApi
import com.example.appservicio.core.translation.Translator
import com.example.appservicio.features.randomadvice.data.datasources.remote.mapper.toDomain
import com.example.appservicio.features.randomadvice.domain.entities.Advice
import com.example.appservicio.features.randomadvice.domain.repositories.AdviceRepository
import com.google.mlkit.nl.translate.TranslateLanguage

// Esta es la implementación del repositorio, aquí es donde "procesamos" los datos
class AdviceRepositoryImpl(
    private val adviceApi: AdviceApi,
    private val translator: Translator
) : AdviceRepository {
    override suspend fun getRandomAdvice(): Advice {
        val adviceDto = adviceApi.getRandomAdvice()
        
        // Usamos el traductor para pasar el texto de Inglés a Español
        val translatedText = translator.translate(
            text = adviceDto.slip.advice,
            sourceLang = TranslateLanguage.ENGLISH,
            targetLang = TranslateLanguage.SPANISH
        )
        
        // Pasamos el objeto que recibimos de la API a nuestra entidad limpia
        return adviceDto.toDomain(translatedText)
    }
}
