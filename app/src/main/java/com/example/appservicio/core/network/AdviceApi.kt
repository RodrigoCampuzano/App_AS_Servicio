package com.example.appservicio.core.network

import com.example.appservicio.features.randomadvice.data.datasources.remote.model.AdviceResponseDto
import retrofit2.http.GET

// Interfaz para Retrofit: Define cómo le pedimos datos a internet.
// Envía: Una orden GET. Recibe: Un objeto DTO con el JSON del consejo.
interface AdviceApi {
    @GET("advice")
    suspend fun getRandomAdvice(): AdviceResponseDto
}
