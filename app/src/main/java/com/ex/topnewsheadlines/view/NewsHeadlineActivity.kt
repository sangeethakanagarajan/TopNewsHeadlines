package com.ex.topnewsheadlines.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ex.topnewsheadlines.R
import com.ex.topnewsheadlines.adapter.NewsListAdapter
import com.ex.topnewsheadlines.viewmodel.NewsHeadlineActivityViewModel
import kotlinx.android.synthetic.main.activity_news_headline.*


class NewsHeadlineActivity : AppCompatActivity() {

    private lateinit var newsHeadlineViewModel: NewsHeadlineActivityViewModel

    private lateinit var newsAdapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_headline)

        newsHeadlineViewModel =
            ViewModelProvider(this).get(NewsHeadlineActivityViewModel::class.java)

        newsHeadlineViewModel.getNewsHeadlineList()
        newsHeadlineViewModel.showProgress.observe(this, Observer {
            if (it) {
                //TODO
            }
        })
        newsAdapter = NewsListAdapter(this)
        recycler_news.adapter = newsAdapter
        recycler_news.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.HORIZONTAL
            )
        )

        newsHeadlineViewModel.newsList.observe(this, Observer {
            newsAdapter.setNewsList(it)
        })

    }
}