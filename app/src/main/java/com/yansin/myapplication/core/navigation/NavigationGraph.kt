package com.yansin.myapplication.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yansin.myapplication.presentation.article.ArticleScreen
import com.yansin.myapplication.presentation.article.ArticleViewModel
import com.yansin.myapplication.presentation.articledetail.ArticleDetailsScreen
import com.yansin.myapplication.presentation.articledetail.ArticleDetailsViewModel


@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationScreen.ArticleListScreen.route,
        modifier = Modifier
    ) {
        composable(NavigationScreen.ArticleListScreen.route) {
            val viewModel: ArticleViewModel = hiltViewModel()
            val articleUiState = viewModel.articleState.value
            ArticleScreen(articleUiState) { id ->
                navController.navigate(NavigationScreen.ArticleDetailsScreen.route + "/$id")
            }
        }
        composable(NavigationScreen.ArticleDetailsScreen.route + "/{id}") {
            val viewModel: ArticleDetailsViewModel = hiltViewModel()
            val articleDetailsUiState = viewModel.articleState.value
            ArticleDetailsScreen(articleDetailsUiState)
        }
    }
}