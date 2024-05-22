package com.arekalov.mytranslator.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
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
    private lateinit var adapter: TranslationHistoryAdapter


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
        setUpAdapter()
        observeHistoryLiveData()
        observeInputEditText()
    }
    /*
    }*/

    private fun observeInputEditText() {
        binding.inputEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewLifecycleOwner.lifecycleScope.launch {
                    delay(500)
                    if (binding.inputEt.text.toString() != "") {
                        val translation =
                            translationViewModel.getTranslation(binding.inputEt.text.toString())
                        if (translation != null) {
                            binding.outputEt.setText(translation.translation)
                        }
                    }
                    else {
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
            .observe(viewLifecycleOwner) { categories ->
                adapter.differ.submitList(categories)
            }
    }

    private fun setUpAdapter() {
        adapter = TranslationHistoryAdapter()
        binding.historyRv.apply {
            adapter = adapter
            layoutManager = LinearLayoutManager(
                activity, LinearLayoutManager.VERTICAL, false
            )
        }
    }
}