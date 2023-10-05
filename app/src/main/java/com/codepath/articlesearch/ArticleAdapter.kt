package com.codepath.articlesearch

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val ARTICLE_EXTRA = "ARTICLE_EXTRA"
private const val TAG = "ArticleAdapter"

class ArticleAdapter(private val context: Context, private val displayArticles: MutableList<DisplayArticle>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val displayArticle = displayArticles[position]
        holder.bind(displayArticle)
    }

    override fun getItemCount() = displayArticles.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val mediaImageView = itemView.findViewById<ImageView>(R.id.mediaImage)
        private val titleTextView = itemView.findViewById<TextView>(R.id.mediaTitle)
        private val abstractTextView = itemView.findViewById<TextView>(R.id.mediaAbstract)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(displayArticle: DisplayArticle) {
            titleTextView.text = displayArticle.headline
            abstractTextView.text = displayArticle.articleAbstract

            Glide.with(context)
                .load(displayArticle.mediaImageUrl)
                .into(mediaImageView)
        }

        override fun onClick(v: View?) {
            // Get selected article
            val displayArticle = displayArticles[absoluteAdapterPosition]

            // Navigate to Details screen and pass selected article
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(ARTICLE_EXTRA, displayArticle)
            context.startActivity(intent)
        }
    }
}