package com.ssverma.uiclone.alphanews.ui.home

import androidx.lifecycle.ViewModel
import com.ssverma.uiclone.alphanews.data.NewsRepository

class HomeViewModel constructor(
    private val newsRepository: NewsRepository = NewsRepository()
) : ViewModel() {

    val news = newsRepository.mockNews
}