package com.ex.topnewsheadlines.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ex.topnewsheadlines.network.model.Articles
import com.ex.topnewsheadlines.repository.NewsDetailHeadlineActivityRepository

class NewsDetailHeadlineActivityViewModel(application: Application) :
    AndroidViewModel(application) {

    private val newsDetailHeadlineRepository = NewsDetailHeadlineActivityRepository(application)
    val newsDetails: LiveData<Articles>

    init {
        this.newsDetails = newsDetailHeadlineRepository.newsDetails
    }

    fun getNewsDetailHeadline(articles: Articles) {
        newsDetailHeadlineRepository.getNewsDetailHeadline(articles)
    }
}