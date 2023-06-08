package com.yansin.myapplication.domain.usecase

import com.yansin.myapplication.core.util.Resource
import com.yansin.myapplication.domain.model.Article
import com.yansin.myapplication.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow

class Article(private val articleRepository: ArticleRepository) {
    operator fun invoke(): Flow<Resource<List<Article>>> {
        return articleRepository.getArticle()
    }
}