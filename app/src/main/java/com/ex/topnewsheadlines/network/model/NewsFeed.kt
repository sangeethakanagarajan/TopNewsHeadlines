package com.ex.topnewsheadlines.network.model

import com.google.gson.annotations.SerializedName

data class NewsFeed(
    @field:SerializedName("status") val status: String,
    @field:SerializedName("totalResults") val totalResults: Int,
    @field:SerializedName("articles") val articles: ArrayList<Articles> = ArrayList<Articles>()
)
