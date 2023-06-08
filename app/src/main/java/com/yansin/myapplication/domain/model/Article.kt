package com.yansin.myapplication.domain.model

data class Article(
    val id:String,
    val title: String,
    val byLine: String,
    val publishedDate: String,
    val abstract: String,
    val image:String,
    val section:String
)
