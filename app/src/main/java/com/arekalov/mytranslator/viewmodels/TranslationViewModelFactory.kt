package com.arekalov.mytranslator.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arekalov.data.api.TranslationRepository
import javax.inject.Inject

class TranslationViewModelFactory @Inject constructor(
    private val repository: TranslationRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TranslationViewModel(repository) as T
    }
}