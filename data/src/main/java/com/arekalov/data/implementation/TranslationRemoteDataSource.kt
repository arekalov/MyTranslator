package com.arekalov.data.implementation

import retrofit2.http.GET
import retrofit2.http.Query

class TranslationRemoteDataSource(
    private val translationApi: TranslationApi
) {
}

interface TranslationApi{
    @GET("api/public/v1/words/{search}")
    suspend fun getTranslation(@Query("search") search: String) :
}