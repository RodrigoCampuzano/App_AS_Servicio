package com.example.appservicio.features.randomadvice.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appservicio.features.randomadvice.presentation.screens.AdviceUiState
import com.example.appservicio.features.randomadvice.domain.usecases.GetRandomAdviceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdviceViewModel @Inject constructor(
    private val getRandomAdviceUseCase: GetRandomAdviceUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<AdviceUiState>(AdviceUiState.Initial)
    val uiState: StateFlow<AdviceUiState> = _uiState.asStateFlow()

    fun fetchAdvice() {
        viewModelScope.launch {
            _uiState.update { AdviceUiState.Loading }
            try {
                val advice = getRandomAdviceUseCase()
                _uiState.update { AdviceUiState.Success(advice) }
            } catch (e: Exception) {
                _uiState.update { AdviceUiState.Error(e.message ?: "Error desconocido") }
            }
        }
    }
}
