package com.arekalov.mytranslator.adapters

import androidx.recyclerview.widget.RecyclerView
import com.arekalov.data.models.TranslationEntity
import com.arekalov.mytranslator.R
import com.arekalov.mytranslator.databinding.TranslationCardBinding


class TranslationHistoryViewHolder(
    private val binding: TranslationCardBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(translation: TranslationEntity) {
        binding.apply {
            inputTv.text = translation.text
            outputTv.text = translation.translation
            if (translation.isFavorite) {
                favoriteBtn.setIconResource(R.drawable.ic_heart_enabled)
            } else {
                favoriteBtn.setIconResource(R.drawable.ic_heart_disabled)
            }
        }
    }
}
