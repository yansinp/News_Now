package com.yansin.myapplication.presentation.articledetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yansin.myapplication.domain.model.Article

@Composable
fun ArticleDetails(article: Article) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = article.image,
            contentDescription =
            "Article Image",
            modifier = Modifier
                .statusBarsPadding()
                .height(293.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop

        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = article.title,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleLarge,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis

            )
            Text(
                text = article.byLine,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Gray,

                )
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = article.section,
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    style = MaterialTheme.typography.titleSmall,
                )
                Row(modifier = Modifier.wrapContentSize()) {
                    Icon(
                        imageVector = Icons.Outlined.DateRange,
                        contentDescription = "",
                        modifier = Modifier.size(16.dp),
                        tint = Color.Gray
                    )

                    Text(
                        text = article.publishedDate,
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(start = 4.dp),
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray,
                        style = MaterialTheme.typography.titleSmall,
                    )
                }
            }
            Text(
                text = article.abstract,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,

                )
        }

    }
}