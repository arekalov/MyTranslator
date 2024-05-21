package com.arekalov.data

import com.arekalov.data.models.TranslationList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

class TranslationRemoteDataSource(
    private val translationApi: TranslationApi
) {
    suspend fun getTranslation(search: String): Response<TranslationList> {
        return translationApi.getTranslation(search)
    }
}

interface TranslationApi{
    @GET("api/public/v1/words/{search}")
    suspend fun getTranslation(@Query("search") search: String) : Response<TranslationList>
}