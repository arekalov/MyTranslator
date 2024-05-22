package com.arekalov.data.impl

import com.arekalov.data.api.TranslationRepository
import com.arekalov.data.models.TranslationEntity
import javax.inject.Inject

internal class TranslationRepositoryImpl @Inject constructor(
    private val translationApi: TranslationApi,
    private val translationDAO: TranslationDAO
) : TranslationRepository{
    override suspend fun getTranslation(search: String): TranslationEntity? {
        try {
            println(search)
            val response = translationApi.getTranslation(search)
            println(response)
            if (response.isSuccessful) {
                val meaning = response.body()!![0].meanings[0]
                println(response.body()!!)
                val entity = TranslationEntity(
                    soundUrl = meaning.soundUrl,
                    translation = meaning.translation.note,
                )
                insertTranslation(entity)
                return entity
            }
            return null
        } catch (ex: Exception) {
            return null
        }
    }

    override suspend fun getHistory(): List<TranslationEntity> {
        return translationDAO.getHistory()
    }

    override suspend fun getFavorite(): List<TranslationEntity> {
        return translationDAO.getFavorite()
    }

    override suspend fun insertTranslation(translation: TranslationEntity) {
        translationDAO.insertTranslation(translation)
    }

    override suspend fun deleteTranslation(translation: TranslationEntity) {
        translationDAO.deleteTranslation(translation)
    }
}
