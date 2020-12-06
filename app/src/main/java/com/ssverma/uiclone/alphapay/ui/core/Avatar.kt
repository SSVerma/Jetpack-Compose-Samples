package com.ssverma.uiclone.alphapay.ui.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawShadow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun Avatar(
    imageUrl: String,
    modifier: Modifier = Modifier,
    size: Dp = 32.dp
) {
    Box(
        modifier = modifier
            .drawShadow(elevation = 2.dp, shape = CircleShape)
            .size(size)
    ) {
        CoilImage(data = imageUrl)
    }
}