package com.arekalov.mytranslator

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.arekalov.mytranslator.viewmodels.TranslationViewModel
import com.arekalov.mytranslator.viewmodels.TranslationViewModelFactory

class MainActivity : AppCompatActivity() {
    internal val translationViewModel: TranslationViewModel by viewModels {
        TranslationViewModelFactory((application as MyTranslatorApplication).dataComponent.getTranslationRepository())
    }

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_main)
    }
}