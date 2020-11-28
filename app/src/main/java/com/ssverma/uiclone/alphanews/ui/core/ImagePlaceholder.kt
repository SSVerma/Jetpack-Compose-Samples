package com.ssverma.uiclone.alphanews.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ImagePlaceholder(height: Dp = 200.dp) {
    Box(
        modifier = Modifier
            .background(color = Color.Gray.copy(alpha = 0.74f))
            .clip(shape = RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .height(height)
    )
}