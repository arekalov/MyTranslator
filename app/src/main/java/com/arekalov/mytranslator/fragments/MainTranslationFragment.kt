package com.arekalov.mytranslator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arekalov.mytranslator.R
import com.arekalov.mytranslator.databinding.FragmentMainTranslationBinding

class MainTranslationFragment : Fragment() {
    private lateinit var binding: FragmentMainTranslationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainTranslationBinding.inflate(inflater)
        return binding.root
    }
}