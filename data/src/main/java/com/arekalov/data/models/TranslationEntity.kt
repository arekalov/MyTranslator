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
    val text: String,
    val isFavorite: Boolean = false,
) : Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TranslationEntity

        if (id != other.id) return false
        if (soundUrl != other.soundUrl) return false
        if (translation != other.translation) return false
        if (text != other.text) return false
        if (isFavorite != other.isFavorite) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + (soundUrl?.hashCode() ?: 0)
        result = 31 * result + translation.hashCode()
        result = 31 * result + text.hashCode()
        result = 31 * result + isFavorite.hashCode()
        return result
    }
}