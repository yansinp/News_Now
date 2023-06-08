package com.yansin.myapplication.presentation.articledetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.yansin.myapplication.presentation.articledetail.components.ArticleDetails

@Composable
fun ArticleDetailsScreen(state: ArticleDetailsUiState) {
    Surface(modifier = Modifier.fillMaxSize()) {

        if (state.loading)
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        else{
            if(state.article==null){
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                   Text(text = "Details Not found")
                }
            }
            else{
                ArticleDetails(state.article)
            }
        }

    }
}


