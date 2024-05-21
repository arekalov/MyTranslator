package com.arekalov.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "translations")
class MeaningEntity(
    @PrimaryKey val id: Int,
    val imageUrl: String?,
    val soundUrl: String?,
    val transcription: String?,
    val translation: String,
    val isFavorite: Boolean = false,
)