package com.arekalov.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.arekalov.data.models.TranslationEntity

@Dao
interface TranslationDAO {
    @Query("SELECT * FROM translations")
    suspend fun getHistory(): List<TranslationEntity>

    @Query("SELECT * FROM translations WHERE isFavorite = 1")
    suspend fun getFavorite(): List<TranslationEntity>

    @Insert
    suspend fun insertTranslation(translationEntity: TranslationEntity)

    @Delete
    suspend fun deleteTranslation(translationEntity: TranslationEntity)
}