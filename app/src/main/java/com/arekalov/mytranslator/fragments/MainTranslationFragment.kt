package com.arekalov.mytranslator.fragments

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arekalov.mytranslator.MainActivity
import com.arekalov.mytranslator.R
import com.arekalov.mytranslator.adapters.TranslationHistoryAdapter
import com.arekalov.mytranslator.databinding.FragmentMainTranslationBinding
import com.arekalov.mytranslator.viewmodels.TranslationViewModel
import kotlinx.coroutines.launch

class MainTranslationFragment : Fragment() {
    private lateinit var binding: FragmentMainTranslationBinding
    private lateinit var translationViewModel: TranslationViewModel
    private lateinit var historyAdapter: TranslationHistoryAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainTranslationBinding.inflate(inflater)
        translationViewModel = (activity as MainActivity).translationViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        translationViewModel.updateHistory()
        setUpAdapter()
        observeHistoryLiveData()
        observeSearchButton()
        setUpClearButton()
        setUpCopyButtons()
        setUpCleanButton()
        itemOnClickListener()
        likeOnClickListener()
        observeFavoriteBtn()
    }

    private fun observeFavoriteBtn() {
        binding.favoriteBtn.setOnClickListener {
            val action =
                MainTranslationFragmentDirections.actionMainTranslationFragmentToFavoriteFragment()
            findNavController().navigate(action)
        }
    }

    private fun likeOnClickListener() {
        historyAdapter.onItemClickListener = { translation ->
            translationViewModel.setFavorite(translation)
        }
    }

    private fun itemOnClickListener() {
        historyAdapter.onCLick = { translationEntity ->
            binding.inputEt.setText(translationEntity.text)
            binding.outputEt.setText(translationEntity.translation)
        }
    }

    private fun observeSearchButton() {
        binding.searchBtn.setOnClickListener {
            binding.outputEt.setText("")
            lifecycleScope.launch {
                if (binding.inputEt.text.toString() != "") {
                    val result =
                        translationViewModel.getTranslation(binding.inputEt.text.toString())
                    if (result != null) {
                        binding.outputEt.setText(result.translation)
                    } else {
                        binding.outputEt.setText(getString(R.string.not_found))
                    }
                } else {
                    binding.outputEt.setText(getString(R.string.not_found))
                }
            }
        }
    }

    private fun setUpCleanButton() {
        binding.deleteAllBtn.setOnClickListener {
            translationViewModel.cleanHistory()
        }
    }

    private fun setUpCopyButtons() {
        binding.copyInputBtn.setOnClickListener {
            val textToCopy = binding.inputEt.text.toString()
            val clipboard =
                requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Copied Text", textToCopy)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(requireContext(), "Text copied to clipboard", Toast.LENGTH_SHORT).show()
        }
        binding.copyOutputBtn.setOnClickListener {
            val textToCopy = binding.outputEt.text.toString()
            val clipboard =
                requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Copied Text", textToCopy)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(requireContext(), "Text copied to clipboard", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setUpClearButton() {
        binding.deleteInputBtn.setOnClickListener {
            binding.inputEt.setText("")
            binding.outputEt.setText("")
        }
    }


    private fun observeHistoryLiveData() {
        translationViewModel.observeHistoryLiveData()
            .observe(viewLifecycleOwner) { data ->
                historyAdapter.differ.submitList(data)
            }
    }

    private fun setUpAdapter() {
        historyAdapter = TranslationHistoryAdapter()
        binding.historyRv.apply {
            adapter = historyAdapter
            layoutManager = LinearLayoutManager(
                activity, LinearLayoutManager.VERTICAL, false
            )
        }
    }
}