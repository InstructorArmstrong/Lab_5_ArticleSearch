package com.codepath.articlesearch

import android.app.Application

// Not created until used
class ArticleApplication : Application() {
    val db by lazy { AppDatabase.getInstance(this) }
}