package com.sdvstark.vintagemoviedb.api

import com.sdvstark.vintagemoviedb.model.LanguagesResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface RemoteApi {
    @GET("configuration/languages")
    fun getLanguages(): Deferred<Response<LanguagesResponse>>
}