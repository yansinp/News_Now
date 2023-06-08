package com.yansin.myapplication.core.navigation

sealed class NavigationScreen(val route:String){
    object ArticleListScreen:NavigationScreen(route="ArticleListScreen")
    object ArticleDetailsScreen:NavigationScreen(route="ArticleDetailsScreen")
}
