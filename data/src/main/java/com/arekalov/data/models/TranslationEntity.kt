package com.arekalov.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "translations")
class TranslationEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val soundUrl: String?,
    val translation: String,
    val isFavorite: Boolean = false,
) : Parcelable