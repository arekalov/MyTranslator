package com.arekalov.data.api

data class Meaning(
    val id: Int,
    val imageUrl: String,
    val partOfSpeechCode: String,
    val previewUrl: String,
    val soundUrl: String,
    val transcription: String,
    val translation: TranslationX
)