package com.example.appservicio.core.di

import com.example.appservicio.core.network.AdviceApi
import com.example.appservicio.core.translation.MLKitTranslator
import com.example.appservicio.core.translation.Translator
import com.example.appservicio.features.randomadvice.data.repositories.AdviceRepositoryImpl
import com.example.appservicio.features.randomadvice.domain.repositories.AdviceRepository
import com.example.appservicio.features.randomadvice.domain.usecases.GetRandomAdviceUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// EN estr se crea y guarda todo lo que la app necesita para funcionar ( Repositorios, etc.)
class AppContainer {
    private val baseUrl = "https://api.adviceslip.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val adviceApi: AdviceApi = retrofit.create(AdviceApi::class.java)
    
    // Se preprara lo del traductor para que funcione
    private val translator: Translator = MLKitTranslator()

    // Se junt la API y el Traductor en el Repositorio (donde se procesan los datos)
    private val adviceRepository: AdviceRepository = AdviceRepositoryImpl(adviceApi, translator)

    // Exponemos el "Caso de Uso" para que el ViewModel lo pueda agarrar fácilmente
    val getRandomAdviceUseCase: GetRandomAdviceUseCase = GetRandomAdviceUseCase(adviceRepository)
}
