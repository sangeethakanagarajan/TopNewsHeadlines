package com.ex.topnewsheadlines.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.ex.topnewsheadlines.network.NewsHeadlinesApi
import com.ex.topnewsheadlines.network.RestApiService
import com.ex.topnewsheadlines.network.model.Articles
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class NewsHeadlineActivityRepository(val application: Application) {

    val showProgress = MutableLiveData<Boolean>()
    val newsList = MutableLiveData<List<Articles>>()

    fun changeProgressState() {
        showProgress.value = !(showProgress.value != null && showProgress.value!!)
    }

    fun getNewsHeadlineList() {
        showProgress.value = true

        //Network call
        val newsService = RestApiService.createService(NewsHeadlinesApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val response =
                newsService.getNewsHeadlineList(RestApiService.country, RestApiService.token)
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        //Do something with response e.g show to the UI.

                        var result = response.body()
                        if (result != null) {
                            newsList.value = result.articles
                        }
                    } else {
                        toast("Error: ${response.code()}")
                    }
                } catch (e: HttpException) {
                    toast("Exception ${e.message}")
                } catch (e: Throwable) {
                    toast("Ooops: Something else went wrong")
                }
            }
        }
    }

    private fun toast(s: String) {
        Toast.makeText(application, s, Toast.LENGTH_SHORT).show()
    }

}



