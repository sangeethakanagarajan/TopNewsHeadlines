package com.ex.topnewsheadlines.network

import com.ex.topnewsheadlines.network.model.NewsFeed
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsHeadlinesApi {

    @GET("v2/top-headlines") // making get request at newsapi end-point
    suspend fun getNewsHeadlineList(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Response<NewsFeed>
}