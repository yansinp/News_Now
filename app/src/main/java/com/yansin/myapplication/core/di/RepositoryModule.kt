package com.yansin.myapplication.core.di

import com.yansin.myapplication.data.repository.ArticleRepositoryImpl
import com.yansin.myapplication.data.source.ArticleService
import com.yansin.myapplication.domain.repository.ArticleRepository
import com.yansin.myapplication.domain.usecase.Article
import com.yansin.myapplication.domain.usecase.ArticleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideArticleRepository(
        articleService: ArticleService
    ): ArticleRepository {
        return ArticleRepositoryImpl(articleService)
    }


    @Provides
    @Singleton
    fun provideArticleUseCase(
        articleRepository: ArticleRepository
    ): ArticleUseCase {
        return ArticleUseCase(article = Article(articleRepository))
    }


}