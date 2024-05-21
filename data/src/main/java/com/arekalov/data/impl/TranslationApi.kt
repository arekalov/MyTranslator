package com.arekalov.data.impl

import com.arekalov.data.models.TranslationList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


internal interface TranslationApi{
    @GET("api/public/v1/words/{search}")
    suspend fun getTranslation(@Query("search") search: String) : Response<TranslationList>
}