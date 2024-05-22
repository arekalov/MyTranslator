package com.arekalov.mytranslator.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.arekalov.data.models.TranslationEntity
import com.arekalov.mytranslator.databinding.TranslationCardBinding

class TranslationHistoryAdapter :
    RecyclerView.Adapter<TranslationHistoryViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<TranslationEntity>() {
        override fun areItemsTheSame(
            oldItem: TranslationEntity,
            newItem: TranslationEntity
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: TranslationEntity,
            newItem: TranslationEntity
        ): Boolean {
            return oldItem == newItem
        }
    }
    var differ = AsyncListDiffer(this, diffUtil)
    var onCLick: ((TranslationEntity) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TranslationHistoryViewHolder {
        return TranslationHistoryViewHolder(
            TranslationCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: TranslationHistoryViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
        holder.itemView.setOnClickListener {
            onCLick!!.invoke(differ.currentList[position])
        }
    }

}