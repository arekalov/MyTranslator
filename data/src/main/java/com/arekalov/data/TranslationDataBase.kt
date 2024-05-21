package com.arekalov.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arekalov.data.models.TranslationEntity

@Database(entities = [TranslationEntity::class], version = 1)
abstract class TranslationDataBase : RoomDatabase() {
    abstract fun getProductDao(): TranslationDAO
}