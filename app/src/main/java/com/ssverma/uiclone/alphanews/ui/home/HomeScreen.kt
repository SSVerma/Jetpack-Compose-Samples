package com.ssverma.uiclone.alphanews.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import com.ssverma.uiclone.alphanews.ui.core.HeadlinesHeader
import com.ssverma.uiclone.alphanews.ui.core.NewsItemBig
import com.ssverma.uiclone.alphanews.ui.core.NewsItemSmall

@Composable
fun HomeScreen() {
    val viewModel = viewModel<HomeViewModel>()

    LazyColumnForIndexed(items = viewModel.news) { index, item ->
        if (index == 0) {
            Column {
                HeadlinesHeader()
                NewsItemBig(news = item, index = index + 1)
            }
        } else {
            NewsItemSmall(news = item, index = index + 1)
        }

        if (index == viewModel.news.lastIndex) {
            Spacer(modifier = Modifier.height(56.dp))//Bottom navigation height
        }
    }
}