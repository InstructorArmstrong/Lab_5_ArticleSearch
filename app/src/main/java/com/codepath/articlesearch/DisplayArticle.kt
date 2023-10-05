package com.codepath.articlesearch

import java.io.Serializable

data class DisplayArticle(
    val headline: String?,
    val articleAbstract: String?,
    val byline: String?,
    val mediaImageUrl: String?
) : Serializable