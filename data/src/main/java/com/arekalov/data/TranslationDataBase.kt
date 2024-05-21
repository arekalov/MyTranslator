package com.arekalov.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arekalov.data.models.TranslationEntity

@Database(entities = [TranslationEntity::class], version = 1)
abstract class TranslationDataBase : RoomDatabase() {
    abstract fun getProductDao(): TranslationDAO
//
//    companion object {
//        private var dbInstance: TranslationDataBase? = null
//        fun getDbInstance(context: Context): TranslationDataBase {
//            if (dbInstance == null) {
//                dbInstance = Room.databaseBuilder<TranslationDataBase>(
//                    context.applicationContext, TranslationDataBase::class.java, "translation_db"
//                )
//                    .allowMainThreadQueries()
//                    .build()
//            }
//            return dbInstance!!
//        }
//    }
}