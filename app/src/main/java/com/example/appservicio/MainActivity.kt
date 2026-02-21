package com.example.appservicio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.appservicio.features.randomadvice.presentation.screens.AdviceScreen
import com.example.appservicio.core.ui.theme.AppServicioTheme
import com.example.appservicio.features.randomadvice.presentation.viewmodels.AdviceViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppServicioTheme {
                AdviceScreen()
            }
        }
    }
}
