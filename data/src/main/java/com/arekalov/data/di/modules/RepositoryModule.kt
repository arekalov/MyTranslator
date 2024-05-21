package com.arekalov.data.di.modules

import TranslationRepository
import com.arekalov.data.TranslationApi
import com.arekalov.data.TranslationDAO
import com.arekalov.data.di.DataModuleScope
import dagger.Module
import dagger.Provides

@Module
object RepositoryModule {
    @DataModuleScope
    @Provides
    fun providesRepository(
        translationApi: TranslationApi,
        translationDAO: TranslationDAO
    ): TranslationRepository {
        return TranslationRepository(translationApi, translationDAO)
    }
}