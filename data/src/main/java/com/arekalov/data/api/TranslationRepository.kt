package com.arekalov.data.api
import com.arekalov.data.models.TranslationEntity

interface TranslationRepository {
    suspend fun getTranslation(search: String): TranslationEntity?
    suspend fun getHistory(): List<TranslationEntity>
    suspend fun getFavorite(): List<TranslationEntity>
    suspend fun insertTranslation(translation: TranslationEntity)
    suspend fun deleteTranslation(translation: TranslationEntity)
}