package com.arekalov.data.models

internal data class TranslationItem(
    val id: Int,
    val meanings: List<Meaning>,
    val text: String
)