package com.ssverma.uiclone.alphapay.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Dot(size: Dp = 12.dp, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(size = size)
            .background(
                color = MaterialTheme.colors.primary,
                shape = CircleShape
            )
    )
}