package com.ssverma.uiclone.alphanews.ui.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.AmbientContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ssverma.uiclone.R

@Composable
fun HeadlinesHeader() {
    Row(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Shyam's briefing",
                style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = "Top 5 stories at the moment",
                style = MaterialTheme.typography.caption.copy(
                    color = AmbientContentColor.current.copy(
                        alpha = 0.74f
                    )
                )
            )
        }
        Column {
            Image(asset = imageResource(id = R.drawable.ic_moon), modifier = Modifier.size(32.dp))
            Text(text = "18\u00B0 C", style = MaterialTheme.typography.caption)
        }
    }
}