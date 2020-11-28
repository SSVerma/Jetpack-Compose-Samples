package com.ssverma.uiclone.alphanews.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.VectorAsset
import com.ssverma.uiclone.R

sealed class BottomNavScreen(val route: String, @StringRes val labelRes: Int, val icon: VectorAsset) {
    object Home : BottomNavScreen(route = "Home", labelRes = R.string.home, Icons.Default.Home)
    object Headlines :
        BottomNavScreen(route = "Headlines", labelRes = R.string.headlines, Icons.Default.List)

    object Following :
        BottomNavScreen(route = "Following", labelRes = R.string.following, Icons.Default.Star)

    object NewsStand :
        BottomNavScreen(route = "NewsStand", labelRes = R.string.news_stand, Icons.Default.Favorite)
}