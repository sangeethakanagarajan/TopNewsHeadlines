package com.ex.topnewsheadlines.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ex.topnewsheadlines.R
import com.ex.topnewsheadlines.network.model.Articles
import com.ex.topnewsheadlines.util.AppUtils
import com.ex.topnewsheadlines.view.NewsDetailHeadlineActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.row_item_feed.view.*


class NewsListAdapter(private val context: Context) :
    RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {

    private var list: List<Articles> = ArrayList<Articles>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_item_feed, parent, false)
        return NewsViewHolder(view, context)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article: Articles = list[position]
        holder.bind(article)
    }

    fun setNewsList(list: List<Articles>?) {
        if (list != null) {
            this.list = list
        }
        notifyDataSetChanged()
    }

    class NewsViewHolder(itemView: View, context: Context) :
        RecyclerView.ViewHolder(itemView) {

        private var articles: Articles? = null

        init {
            itemView.setOnClickListener {
                articles.let {
                    val intent = Intent(context, NewsDetailHeadlineActivity::class.java)
                    intent.putExtra("articles", Gson().toJson(articles))
                    context.startActivity(intent)
                }
            }

        }

        fun bind(articles: Articles) {
            this.articles = articles
            itemView.txt_headline_title.text = articles.title

            val resources = this.itemView.context.resources
            itemView.txt_news_source_date.text = String.format(
                resources.getString(R.string.item_source_date),
                articles.source.sourceName,
                AppUtils.getDate(articles.publishedAt),
                AppUtils.getTime(articles.publishedAt)
            )

            Glide.with(itemView)
                .load(articles.urlToImage)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .fallback(R.drawable.placeholder)
                .into(itemView.img_news)

        }
    }
}