package com.ssverma.uiclone.alphanews.ui.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.ripple.RippleIndication
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ssverma.uiclone.R
import com.ssverma.uiclone.alphanews.data.News
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun NewsItemBig(news: News, index: Int = -1) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = {})
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        CoilImage(
            data = news.imageUrl,
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(size = 8.dp)),
            contentScale = ContentScale.Crop,
            loading = {
                ImagePlaceholder()
            },
            error = {
                ImagePlaceholder()
            }
        )
        Row(modifier = Modifier.padding(top = 16.dp)) {
            if (index > 0) {
                Text(
                    text = "$index.",
                    modifier = Modifier.padding(end = 8.dp),
                    color = MaterialTheme.colors.secondary,
                    style = MaterialTheme.typography.body2
                )
            }
            Column {
                NewsProviderLogo(news)
                Text(
                    text = news.title,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(top = 8.dp)
                )
                NewsItemLabelAndTimestamp(news)
                Divider(modifier = Modifier.padding(top = 16.dp))
            }
        }
    }
}

@Composable
fun NewsProviderLogo(news: News) {
    CoilImage(
        data = news.newsProviderLogo,
        modifier = Modifier.height(24.dp).width(72.dp)
    )
}

@Composable
fun NewsItemLabelAndTimestamp(news: News) {
    Row(
        modifier = Modifier.padding(top = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (!news.label.isNullOrEmpty()) {
            Text(
                text = news.label,
                style = MaterialTheme.typography.body2.copy(
                    fontWeight = FontWeight.Bold,
                    color = AmbientContentColor.current.copy(alpha = 0.54f)
                )
            )
            Box(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(4.dp)
                    .background(
                        color = Color.Gray,
                        shape = RoundedCornerShape(percent = 50)
                    )
            )
        }
        Text(
            text = news.timestamp,
            style = MaterialTheme.typography.caption,
            color = AmbientContentColor.current.copy(alpha = 0.54f)
        )
        NewsItemActions(news)
    }
}

@Composable
fun NewsItemActions(news: News) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        if (news.isFullCoverageAvailable) {
            Image(
                asset = imageResource(id = R.drawable.ic_coverage),
                modifier = Modifier
                    .size(28.dp)
                    .padding(end = 8.dp)
                    .clickable(onClick = {

                    }, indication = RippleIndication(bounded = false))
            )
        }
        Icon(
            asset = Icons.Default.MoreVert,
            tint = Color.Gray,
            modifier = Modifier.clickable(onClick = {

            }, indication = RippleIndication(bounded = false))
        )
    }

}
