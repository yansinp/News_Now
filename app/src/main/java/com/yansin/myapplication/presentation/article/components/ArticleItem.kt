package com.yansin.myapplication.presentation.article.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.yansin.myapplication.domain.model.Article


@Composable
fun ArticleItem(article: Article, onItemClick: (String) -> Unit) {
    Surface(
        modifier = Modifier
            .clickable { onItemClick.invoke(article.id) }
            .padding(vertical = 8.dp)
            .wrapContentHeight()
            .background(MaterialTheme.colorScheme.onSurface)
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            AsyncImage(model=article.image,
                contentDescription="ArticleImage",
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop

            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .wrapContentHeight()
                    .weight(1f)
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
                        .padding(top = 4.dp),
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

            }
            Icon(imageVector = Icons.Outlined.KeyboardArrowRight, contentDescription = "")

        }
    }

}