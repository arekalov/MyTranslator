package com.arekalov.data.di

import android.content.Context
import androidx.room.Room
import com.arekalov.data.TranslationDAO
import com.arekalov.data.TranslationDataBase
import dagger.Module
import dagger.Provides

@Module
object DatabaseModule {
    @Provides
    fun provideDatabase(context: Context): TranslationDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            TranslationDataBase::class.java,
            "translation_db"
        ).build()
    }

    @Provides
    fun provideTranslationDao(dataBase: TranslationDataBase): TranslationDAO {
        return dataBase.getProductDao()
    }
}