package com.arekalov.mytranslator.di

import com.arekalov.data.api.TranslationRepository
import com.arekalov.data.di.DataComponent
import com.arekalov.data.di.DataModuleScope
import dagger.Component
import javax.inject.Singleton
@DataModuleScope
@Component(dependencies = [DataComponent::class])
interface AppComponent {
    fun getTranslationRepository(): TranslationRepository
}