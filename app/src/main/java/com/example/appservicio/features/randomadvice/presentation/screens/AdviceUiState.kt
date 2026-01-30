package com.example.appservicio.features.randomadvice.presentation.screens

import com.example.appservicio.features.randomadvice.domain.entities.Advice

sealed interface AdviceUiState {
    object Loading : AdviceUiState
    data class Success(val advice: Advice) : AdviceUiState
    data class Error(val message: String) : AdviceUiState
    object Initial : AdviceUiState
}
