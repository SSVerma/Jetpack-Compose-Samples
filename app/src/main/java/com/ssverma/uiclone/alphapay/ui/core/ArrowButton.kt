package com.ssverma.uiclone.alphapay.ui.core

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.unit.dp
import com.ssverma.uiclone.alphapay.ui.AppIcons

@Composable
fun ArrowButton(
    onClick: () -> Unit,
    startIcon: VectorAsset,
    text: String,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Icon(asset = startIcon, tint = MaterialTheme.colors.primary)
        Text(
            text = text,
            style = MaterialTheme.typography.button,
            modifier = Modifier.weight(1f).padding(horizontal = 16.dp)
        )
        Icon(asset = AppIcons.KeyboardArrowRight)
    }
}