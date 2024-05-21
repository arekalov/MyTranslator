package com.arekalov.data

import com.arekalov.data.models.Meaning
import com.arekalov.data.models.MeaningEntity

class TranslationRepository(
    private val translationRemoteDataSource: TranslationRemoteDataSource
) {
    suspend fun getTranslation(search: String): MeaningEntity? {
        try {
            val response = translationRemoteDataSource.getTranslation(search)
            if (response.isSuccessful) {
                val meaning = response.body()!![0].meanings[0]
                return MeaningEntity(
                    id = meaning.id,
                    imageUrl = meaning.imageUrl,
                    soundUrl = meaning.soundUrl,
                    translation = meaning.translation.text,
                    transcription = meaning.transcription
                )
            }
            return null
        } catch (ex: Exception) {
            return null
        }
    }


}