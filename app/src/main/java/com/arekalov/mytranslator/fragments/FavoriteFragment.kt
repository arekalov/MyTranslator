package com.arekalov.mytranslator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arekalov.mytranslator.MainActivity
import com.arekalov.mytranslator.R
import com.arekalov.mytranslator.adapters.TranslationHistoryAdapter
import com.arekalov.mytranslator.databinding.FragmentFavoriteBinding
import com.arekalov.mytranslator.viewmodels.TranslationViewModel
import kotlinx.coroutines.delay


class FavoriteFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var translationViewModel: TranslationViewModel
    private lateinit var historyAdapter: TranslationHistoryAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        translationViewModel = (activity as MainActivity).translationViewModel
        setUpAdapter()
        observeHistoryLiveData()
        likeOnClickListener()
    }

    private fun setUpAdapter() {
        historyAdapter = TranslationHistoryAdapter()
        binding.favoriteRv.apply {
            adapter = historyAdapter
            layoutManager = LinearLayoutManager(
                activity, LinearLayoutManager.VERTICAL, false
            )
        }
    }


    private fun likeOnClickListener() {
        historyAdapter.onItemClickListener = { translation ->
            translationViewModel.setFavorite(translation)
        }
    }

    private fun observeHistoryLiveData() {
        translationViewModel.observeHistoryLiveData()
            .observe(viewLifecycleOwner) { data ->
                historyAdapter.differ.submitList(data.filter { it.isFavorite })
            }
    }
}