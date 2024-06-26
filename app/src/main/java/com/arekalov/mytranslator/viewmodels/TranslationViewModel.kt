package com.arekalov.mytranslator.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arekalov.data.api.TranslationRepository
import com.arekalov.data.models.TranslationEntity
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


class TranslationViewModel @Inject constructor(
    private val repository: TranslationRepository
) : ViewModel() {
    private val historyLiveData = MutableLiveData<List<TranslationEntity>>()

    init {
        updateHistory()
    }

    fun updateHistory() {
        viewModelScope.launch {
            try {
                val result = repository.getHistory()
                historyLiveData.value = result
            } catch (_: Exception) {
            }
        }
    }



    suspend fun getTranslation(search: String): TranslationEntity? {
        val result = repository.getTranslation(search)
        println(result)
        if (result != null) updateHistory()
        return result
    }

    fun cleanHistory() {
        viewModelScope.launch {
            repository.deleteAll()
            updateHistory()
        }
    }

    fun setFavorite(translationEntity: TranslationEntity) {
        viewModelScope.launch {
            translationEntity.isFavorite = !translationEntity.isFavorite
            repository.setFavorite(translationEntity)
            updateHistory()
        }
    }

    fun observeHistoryLiveData(): LiveData<List<TranslationEntity>> = historyLiveData
}