package com.example.appservicio.features.randomadvice.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appservicio.features.randomadvice.domain.usecases.GetRandomAdviceUseCase

class AdviceViewModelFactory(
    private val getRandomAdviceUseCase: GetRandomAdviceUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AdviceViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AdviceViewModel(getRandomAdviceUseCase) as T
        }
        throw IllegalArgumentException("Clae viewmodel desconocida")
    }
}
