package com.arekalov.mytranslator.fragments

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.arekalov.mytranslator.MainActivity
import com.arekalov.mytranslator.adapters.TranslationHistoryAdapter
import com.arekalov.mytranslator.databinding.FragmentMainTranslationBinding
import com.arekalov.mytranslator.viewmodels.TranslationViewModel
import kotlinx.coroutines.delay
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
        observeInputEditText()
        setUpClearButton()
        setUpCopyButtons()
        setUpCleanButton()
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

    private fun observeInputEditText() {
        binding.inputEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewLifecycleOwner.lifecycleScope.launch {
                    delay(1000)
                    if (binding.inputEt.text.toString() != "") {
                        val translation =
                            translationViewModel.getTranslation(binding.inputEt.text.toString())
                        if (translation != null) {
                            binding.outputEt.setText(translation.translation)
                        }
                    } else {
                        binding.outputEt.setText("")
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    private fun observeHistoryLiveData() {
        translationViewModel.observeHistoryLiveData()
            .observe(viewLifecycleOwner) { data ->
                historyAdapter.differ.submitList(data)
                println(historyAdapter.differ.currentList.size)
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