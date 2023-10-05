package com.codepath.articlesearch

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Query("SELECT * FROM article_table")
    fun getAll(): Flow<List<ArticleEntity>>

    @Insert
    fun insertAll(articles: List<ArticleEntity>)

    @Query("DELETE FROM article_table")
    fun deleteAll()
}