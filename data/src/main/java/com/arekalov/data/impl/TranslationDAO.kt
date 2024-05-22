package com.arekalov.data.impl

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.arekalov.data.models.TranslationEntity

@Dao
internal interface TranslationDAO {

    @Query("SELECT * FROM translations ORDER BY id DESC")
    suspend fun getHistory(): List<TranslationEntity>

    @Query("SELECT * FROM translations WHERE isFavorite = 1")
    suspend fun getFavorite(): List<TranslationEntity>

    @Insert
    suspend fun insertTranslation(translationEntity: TranslationEntity)

    @Delete
    suspend fun deleteTranslation(translationEntity: TranslationEntity)

    @Query("DELETE FROM translations")
    suspend fun deleteAllTranslations()

    @Update
    suspend fun setFavorite(translationEntity: TranslationEntity)
}