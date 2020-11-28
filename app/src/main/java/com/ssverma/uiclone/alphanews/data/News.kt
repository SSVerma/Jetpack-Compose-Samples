package com.ssverma.uiclone.alphanews.data

data class News(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val label: String?,
    val timestamp: String,
    val newsProviderLogo: String,
    val isFullCoverageAvailable: Boolean
)