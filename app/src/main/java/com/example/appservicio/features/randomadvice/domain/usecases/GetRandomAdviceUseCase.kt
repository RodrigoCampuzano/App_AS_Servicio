package com.example.appservicio.features.randomadvice.domain.usecases

import com.example.appservicio.features.randomadvice.domain.entities.Advice
import com.example.appservicio.features.randomadvice.domain.repositories.AdviceRepository

class GetRandomAdviceUseCase(
    private val repository: AdviceRepository
) {
    suspend operator fun invoke(): Advice {
        return repository.getRandomAdvice()
    }
}
