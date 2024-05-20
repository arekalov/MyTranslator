package com.arekalov.data.models

import com.arekalov.data.TranslationRemoteDataSource

class TranslationRepository(
    private val translationRemoteDataSource: TranslationRemoteDataSource
) {
    suspend fun getTranslation(search: String): Meaning? {
        try {
            val response = translationRemoteDataSource.getTranslation(search)
            if (response.isSuccessful) {
                return response.body()!![0].meanings[0]
            }
            return null
        } catch (ex: Exception) {
            return null
        }
    }
}