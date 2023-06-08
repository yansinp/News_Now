package com.yansin.myapplication.presentation.articledetail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yansin.myapplication.core.util.Resource
import com.yansin.myapplication.domain.usecase.ArticleUseCase
import com.yansin.myapplication.presentation.article.ArticleUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleDetailsViewModel @Inject constructor(
    private val articleUseCase: ArticleUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    private val id = savedStateHandle.get<String>("id")

    var articleState = mutableStateOf(ArticleDetailsUiState())
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
                        val response = it.value.find { item -> item.id == id }
                        articleState.value =
                            articleState.value.copy(error = "", loading = false, article = response)
                    }

                    else -> {}
                }
            }
        }
    }
}