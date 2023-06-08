package com.yansin.myapplication.data.repository

import com.skydoves.sandwich.StatusCode
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import com.yansin.myapplication.core.util.Constants
import com.yansin.myapplication.core.util.Constants.GENERAL_ERROR_MESSAGE
import com.yansin.myapplication.core.util.Resource
import com.yansin.myapplication.data.source.ArticleService
import com.yansin.myapplication.domain.model.Article
import com.yansin.myapplication.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ArticleRepositoryImpl(private val articleService: ArticleService) : ArticleRepository {
    override fun getArticle(): Flow<Resource<List<Article>>> = flow {
        emit(Resource.Loading)
        articleService.getArticles("RoNcdIDjxcpc1GfOTE3opIbeMfGZXCNi").suspendOnSuccess {
            val response = this.data
            if (response.status.equals("OK")) {
                emit(Resource.Success(response.results?.map { it.toArticle() } ?: emptyList()))
            } else {
                emit(Resource.Error(GENERAL_ERROR_MESSAGE))
            }
        }
            .suspendOnError {
                try {

                    when (this.statusCode) {
                        StatusCode.InternalServerError -> emit(Resource.Error(Constants.SERVER_ERROR))
                        else -> {
                            emit(Resource.Error("Unable to fetch article details"))
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Error(GENERAL_ERROR_MESSAGE))
                }
            }
            .suspendOnException { emit(Resource.Error(Constants.NO_INTERNET_ERROR_MESSAGE)) }

    }
}