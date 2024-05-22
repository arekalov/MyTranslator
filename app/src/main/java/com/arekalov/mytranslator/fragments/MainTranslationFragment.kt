package com.arekalov.mytranslator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arekalov.mytranslator.MainActivity
import com.arekalov.mytranslator.R
import com.arekalov.mytranslator.databinding.FragmentMainTranslationBinding
import com.arekalov.mytranslator.viewmodels.TranslationViewModel

class MainTranslationFragment : Fragment() {
    private lateinit var binding: FragmentMainTranslationBinding
    private lateinit var translationViewModel: TranslationViewModel


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

    }
}