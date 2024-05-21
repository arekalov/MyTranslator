package com.arekalov.data.di

import com.arekalov.data.TranslationApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dictionary.skyeng.ru/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesTranslationApi(retrofit: Retrofit): TranslationApi {
        return retrofit.create(TranslationApi::class.java)
    }
}