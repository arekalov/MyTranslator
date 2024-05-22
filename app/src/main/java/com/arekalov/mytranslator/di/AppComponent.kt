package com.arekalov.mytranslator.di

import com.arekalov.data.di.DataComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun dataComponent(): DataComponent.Builder
}