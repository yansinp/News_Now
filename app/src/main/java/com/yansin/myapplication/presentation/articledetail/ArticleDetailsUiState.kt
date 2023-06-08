package com.yansin.myapplication.presentation.articledetail

import com.yansin.myapplication.domain.model.Article

data class ArticleDetailsUiState(
    val article: Article?=null,
    val error: String = "",
    val loading: Boolean = false
)
