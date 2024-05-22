package com.arekalov.mytranslator

import android.app.Application
import com.arekalov.data.di.DataComponent
import com.arekalov.mytranslator.di.AppComponent
import com.arekalov.mytranslator.di.DaggerAppComponent

class MyTranslatorApplication : Application() {
    internal lateinit var appComponent: AppComponent
    internal lateinit var dataComponent: DataComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
        dataComponent = appComponent.dataComponent().context(applicationContext).build()
    }
}