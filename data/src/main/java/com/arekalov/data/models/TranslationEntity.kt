package com.arekalov.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "translations")
class TranslationEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val imageUrl: String?,
    val soundUrl: String?,
    val transcription: String?,
    val translation: String,
    val isFavorite: Boolean = false,
)