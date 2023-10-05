package com.codepath.articlesearch

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity(tableName = "article_table")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "headline") val headline: String?,
    @ColumnInfo(name = "articleAbstract") val articleAbstract: String?,
    @ColumnInfo(name = "byline") val byline: String?,
    @ColumnInfo(name = "mediaImageUrl") val mediaImageUrl: String?
)