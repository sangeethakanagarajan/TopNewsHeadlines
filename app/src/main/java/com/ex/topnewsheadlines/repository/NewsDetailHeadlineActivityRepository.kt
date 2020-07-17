package com.ex.topnewsheadlines.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ex.topnewsheadlines.network.model.Articles

class NewsDetailHeadlineActivityRepository(val application: Application) {

    val newsDetails = MutableLiveData<Articles>()

    fun getNewsDetailHeadline(newsDetail: Articles) {
        newsDetails.value = newsDetail
    }

}

