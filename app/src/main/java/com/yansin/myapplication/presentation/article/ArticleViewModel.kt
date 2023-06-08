package com.yansin.myapplication.presentation.article

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yansin.myapplication.core.util.Resource
import com.yansin.myapplication.domain.repository.ArticleRepository
import com.yansin.myapplication.domain.usecase.ArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(private val articleUseCase: ArticleUseCase) :
    ViewModel() {
    var articleState = mutableStateOf(ArticleUiState())
        private set

    init {
        viewModelScope.launch {
            articleUseCase.article.invoke().collect {
                when (it) {
                    is Resource.Error -> {
                        articleState.value =
                            articleState.value.copy(error = it.error, loading = false)
                    }

                    is Resource.Loading -> {
                        articleState.value = articleState.value.copy(loading = true)
                    }

                    is Resource.Success -> {
                        articleState.value =
                            articleState.value.copy(error = "", loading = false, article = it.value)
                    }

                    else -> {}
                }
            }
        }
    }
}