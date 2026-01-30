package com.example.appservicio.features.randomadvice.domain.repositories

import com.example.appservicio.features.randomadvice.domain.entities.Advice

interface AdviceRepository {
    suspend fun getRandomAdvice(): Advice
}
