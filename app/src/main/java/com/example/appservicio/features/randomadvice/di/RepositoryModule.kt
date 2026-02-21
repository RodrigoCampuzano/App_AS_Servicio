package com.example.appservicio.features.randomadvice.di

import com.example.appservicio.core.translation.MLKitTranslator
import com.example.appservicio.core.translation.Translator
import com.example.appservicio.features.randomadvice.data.repositories.AdviceRepositoryImpl
import com.example.appservicio.features.randomadvice.domain.repositories.AdviceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAdviceRepository(
        adviceRepositoryImpl: AdviceRepositoryImpl
    ): AdviceRepository

    @Binds
    @Singleton
    abstract fun bindTranslator(
        mlKitTranslator: MLKitTranslator
    ): Translator
}
