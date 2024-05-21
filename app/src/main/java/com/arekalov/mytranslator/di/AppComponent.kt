package com.arekalov.mytranslator.di

import com.arekalov.data.api.TranslationRepository
import com.arekalov.data.di.DataComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [DataComponent::class])
interface AppComponent {
    fun getTranslationRepository(): TranslationRepository
}