package com.arekalov.data.api

data class TranslationItem(
    val id: Int,
    val meanings: List<Meaning>,
    val text: String
)