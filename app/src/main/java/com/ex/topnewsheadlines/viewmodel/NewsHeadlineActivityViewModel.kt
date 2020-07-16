package com.ex.topnewsheadlines.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ex.topnewsheadlines.network.model.Articles
import com.ex.topnewsheadlines.repository.NewsHeadlineActivityRepository

class NewsHeadlineActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val newsHeadlineRepository = NewsHeadlineActivityRepository(application)
    val showProgress: LiveData<Boolean>
    val newsList: LiveData<List<Articles>>

    init {
        this.showProgress = newsHeadlineRepository.showProgress
        this.newsList = newsHeadlineRepository.newsList
    }

    fun changeProgressState() {
        newsHeadlineRepository.changeProgressState()
    }

    fun getNewsHeadlineList() {
        newsHeadlineRepository.getNewsHeadlineList()
    }
}

