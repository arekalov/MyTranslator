package com.arekalov.data.di

import android.content.Context
import com.arekalov.data.api.TranslationRepository
import com.arekalov.data.di.modules.DatabaseModule
import com.arekalov.data.di.modules.NetworkModule
import com.arekalov.data.di.modules.RepositoryModule
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [DatabaseModule::class, NetworkModule::class, RepositoryModule::class])
interface DataComponent {
    fun getTranslationRepository(): TranslationRepository
    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): DataComponent
    }
}