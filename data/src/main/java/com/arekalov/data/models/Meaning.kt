package com.arekalov.data.models


internal data class Meaning(
    val id: Int,
    val text: String,
    val imageUrl: String,
    val partOfSpeechCode: String,
    val previewUrl: String,
    val soundUrl: String,
    val transcription: String,
    val translation: Translation
)