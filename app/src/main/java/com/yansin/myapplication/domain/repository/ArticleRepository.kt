package com.yansin.myapplication.domain.repository

import com.yansin.myapplication.core.util.Resource
import com.yansin.myapplication.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
 fun getArticle():Flow<Resource<List<Article>>>
}