package com.yansin.myapplication.presentation.article

import com.yansin.myapplication.domain.model.Article

data class ArticleUiState(
    val article: List<Article> = emptyList(),
    val error: String = "",
    val loading: Boolean = false
)
