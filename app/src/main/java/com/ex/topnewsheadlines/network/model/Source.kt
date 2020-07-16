package com.ex.topnewsheadlines.network.model

import com.google.gson.annotations.SerializedName

data class Source(
    @field:SerializedName("id") val id: String?,
    @field:SerializedName("name") val sourceName: String
)