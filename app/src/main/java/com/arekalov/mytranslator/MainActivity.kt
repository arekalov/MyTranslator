package com.arekalov.mytranslator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.arekalov.data.di.DataComponent
import com.arekalov.mytranslator.di.AppComponent
import com.arekalov.mytranslator.di.DaggerAppComponent
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var appComponent: AppComponent
    private lateinit var dataComponent: DataComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appComponent = DaggerAppComponent.builder().build()
        dataComponent = appComponent.dataComponent().context(applicationContext).build()
    }

}