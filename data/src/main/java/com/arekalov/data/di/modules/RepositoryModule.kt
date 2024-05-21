package com.arekalov.data.di.modules

import com.arekalov.data.api.TranslationRepository
import com.arekalov.data.impl.TranslationRepositoryImpl
import com.arekalov.data.impl.TranslationApi
import com.arekalov.data.impl.TranslationDAO
import com.arekalov.data.di.DataModuleScope
import dagger.Module
import dagger.Provides

@Module
internal object RepositoryModule {
    @DataModuleScope
    @Provides
    fun providesRepository(
        translationApi: TranslationApi,
        translationDAO: TranslationDAO
    ): TranslationRepositoryImpl {
        return TranslationRepositoryImpl(translationApi, translationDAO)
    }
    @DataModuleScope
    @Provides
    fun provideTranslationRepositoryInterface(implementation: TranslationRepositoryImpl): TranslationRepository {
        return implementation
    }
}