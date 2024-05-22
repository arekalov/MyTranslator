package com.arekalov.data.di.modules

import android.content.Context
import androidx.room.Room
import com.arekalov.data.impl.TranslationDAO
import com.arekalov.data.impl.TranslationDataBase
import dagger.Module
import dagger.Provides

@Module
internal object DatabaseModule {
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