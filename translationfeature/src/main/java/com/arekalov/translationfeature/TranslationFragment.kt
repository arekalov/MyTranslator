package com.arekalov.translationfeature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.arekalov.translationfeature.databinding.FragmentTranslationBinding

class TranslationFragment : Fragment() {
    private lateinit var binding: FragmentTranslationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTranslationBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnClick.setOnClickListener {
            val action = TranslationFragmentDirections.actionTranslationFragmentToFavoriteFragment()
            findNavController().navigate(action)
        }
    }
}