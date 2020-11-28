package com.ssverma.uiclone.alphanews.ui.core

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ssverma.uiclone.alphanews.data.News
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun NewsItemSmall(news: News, index: Int = -1) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = {})
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        Row {
            if (index > 0) {
                Text(
                    text = "$index.",
                    modifier = Modifier.padding(end = 8.dp),
                    color = MaterialTheme.colors.secondary,
                    style = MaterialTheme.typography.body2
                )
            }
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(modifier = Modifier.weight(weight = 1f)) {
                        NewsProviderLogo(news)
                        Text(
                            text = news.title,
                            style = MaterialTheme.typography.body1.copy(
                                fontSize = 18.sp
                            ),
                            modifier = Modifier.padding(top = 8.dp, end = 16.dp)
                        )
                    }
                    CoilImage(
                        data = news.imageUrl,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(size = 8.dp)),
                        contentScale = ContentScale.Crop,
                        loading = {
                            ImagePlaceholder()
                        },
                        error = {
                            ImagePlaceholder()
                        }
                    )
                }
                NewsItemLabelAndTimestamp(news)
                Divider(modifier = Modifier.padding(top = 16.dp))
            }
        }
    }
}