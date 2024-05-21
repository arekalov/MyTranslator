package com.arekalov.data.impl

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arekalov.data.models.TranslationEntity

@Database(entities = [TranslationEntity::class], version = 1, exportSchema = false)
internal abstract class TranslationDataBase : RoomDatabase() {
    abstract fun getProductDao(): TranslationDAO
}