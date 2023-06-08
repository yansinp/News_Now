package com.yansin.myapplication.data.source

import com.skydoves.sandwich.ApiResponse
import com.yansin.myapplication.data.dto.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService {

    @GET("7.json")
    suspend fun getArticles(@Query("api-key") key:String):ApiResponse<ResponseDto>
}