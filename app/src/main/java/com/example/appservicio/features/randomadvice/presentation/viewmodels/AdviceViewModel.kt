package com.example.appservicio.features.randomadvice.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appservicio.features.randomadvice.domain.usecases.GetRandomAdviceUseCase
import com.example.appservicio.features.randomadvice.presentation.screens.AdviceUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// Este es el "puente" entre la pantalla y la lógica. Maneja el estado de la UI.
class AdviceViewModel(
    private val getRandomAdviceUseCase: GetRandomAdviceUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<AdviceUiState>(AdviceUiState.Initial)

    val uiState: StateFlow<AdviceUiState> = _uiState.asStateFlow()

    fun fetchAdvice() {
        viewModelScope.launch {
            _uiState.value = AdviceUiState.Loading
            try {
                val advice = getRandomAdviceUseCase()
                _uiState.value = AdviceUiState.Success(advice)
            } catch (e: Exception) {
                _uiState.value = AdviceUiState.Error(e.message ?: "Error desconocido")
            }
        }
    }
}
