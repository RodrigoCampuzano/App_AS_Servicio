package com.example.appservicio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appservicio.core.di.AppContainer
import com.example.appservicio.features.randomadvice.presentation.screens.AdviceScreen
import com.example.appservicio.features.randomadvice.presentation.viewmodels.AdviceViewModelFactory
import com.example.appservicio.core.ui.theme.AppServicioTheme
import com.example.appservicio.features.randomadvice.presentation.viewmodels.AdviceViewModel

class MainActivity : ComponentActivity() {

    private lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        appContainer = AppContainer()
        
        enableEdgeToEdge()
        setContent {
            AppServicioTheme {
                val viewModel: AdviceViewModel = viewModel(
                    factory = AdviceViewModelFactory(appContainer.getRandomAdviceUseCase)
                )
                
                AdviceScreen(viewModel = viewModel)
            }
        }
    }
}
