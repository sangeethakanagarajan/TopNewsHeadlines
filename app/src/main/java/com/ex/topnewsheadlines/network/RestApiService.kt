package com.ex.topnewsheadlines.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestApiService {

    const val API_BASE_URL = "https://newsapi.org/"
    const val token = "21e3e39250904c5881a3bf9bc085d20b"
    const val country = "us"

    private val retrofit = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <S> createService(serviceClass: Class<S>?): S {
        return retrofit.create(serviceClass)
    }
}
