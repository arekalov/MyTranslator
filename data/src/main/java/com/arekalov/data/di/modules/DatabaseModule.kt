package com.arekalov.data.di.modules

import android.content.Context
import androidx.room.Room
import com.arekalov.data.TranslationDAO
import com.arekalov.data.TranslationDataBase
import com.arekalov.data.di.DataModuleScope
import dagger.Module
import dagger.Provides

@Module
object DatabaseModule {
    @DataModuleScope
    @Provides
    fun provideDatabase(context: Context): TranslationDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            TranslationDataBase::class.java,
            "translation_db"
        ).build()
    }
    @DataModuleScope
    @Provides
    fun provideTranslationDao(dataBase: TranslationDataBase): TranslationDAO {
        return dataBase.getProductDao()
    }
}