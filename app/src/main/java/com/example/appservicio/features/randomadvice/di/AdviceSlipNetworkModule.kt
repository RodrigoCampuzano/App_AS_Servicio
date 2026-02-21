package com.example.appservicio.features.randomadvice.di

import com.example.appservicio.core.di.AdviceSlipRetrofit
import com.example.appservicio.core.network.AdviceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AdviceSlipNetworkModule {

    @Provides
    @Singleton
    fun provideAdviceApi(@AdviceSlipRetrofit retrofit: Retrofit): AdviceApi {
        return retrofit.create(AdviceApi::class.java)
    }
}
