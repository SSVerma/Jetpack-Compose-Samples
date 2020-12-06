package com.ssverma.uiclone.alphapay.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.ripple.RippleIndication
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.unit.dp
import com.ssverma.uiclone.alphapay.data.SectionActionData
import com.ssverma.uiclone.alphapay.ui.AppIcons
import com.ssverma.uiclone.alphapay.ui.core.Avatar
import com.ssverma.uiclone.alphapay.ui.core.Dot
import com.ssverma.uiclone.alphapay.ui.core.Grid

@Composable
private fun SectionTitle(
    title: String,
    sectionActionData: SectionActionData? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = if (sectionActionData == null) {
            Arrangement.Start
        } else {
            Arrangement.SpaceBetween
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(start = 16.dp)
        )
        sectionActionData?.let {
            SectionAction(label = it.label, icon = it.icon)
        }
    }
}

@Composable
private fun SectionAction(label: String, icon: VectorAsset?) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .clickable(onClick = {}, indication = RippleIndication())
            .background(
                color = MaterialTheme.colors.primary.copy(alpha = 0.16f),
                shape = RoundedCornerShape(percent = 50)
            ).padding(horizontal = 12.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon?.let {
            Icon(
                asset = it,
                tint = MaterialTheme.colors.primary,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(16.dp)
            )
        }
        Text(
            text = label,
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.primary
        )
    }
}

@Composable
fun SectionItem(
    imageUrl: String,
    title: String,
    onClick: () -> Unit,
    isNotificationAvailable: Boolean = false
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.clickable(
                onClick = onClick,
                indication = RippleIndication(bounded = false)
            )
        ) {
            Avatar(imageUrl = imageUrl, size = 44.dp)
            if (isNotificationAvailable) {
                Dot(modifier = Modifier.align(Alignment.TopEnd))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = title, style = MaterialTheme.typography.caption)
    }
}

@Composable
fun <T> HomeSection(
    sectionTitle: String,
    sectionActionData: SectionActionData? = null,
    items: List<T>,
    collapseThreshold: Int = 7,
    sectionItemContent: @Composable (item: T, index: Int) -> Unit
) {
    var isSectionCollapsed by remember { mutableStateOf(true) }

    val collapsedItemCount = remember {
        if (items.size < collapseThreshold) {
            items.size
        } else {
            collapseThreshold
        }
    }

    Column {
        SectionTitle(title = sectionTitle, sectionActionData = sectionActionData)
        Spacer(modifier = Modifier.preferredHeight(12.dp))
        Grid(
            items = if (isSectionCollapsed) items.subList(0, collapsedItemCount) else items,
            leading = if (items.size > collapseThreshold) {
                {
                    ExpandCollapseAction(
                        onClick = {
                            isSectionCollapsed = !isSectionCollapsed
                        },
                        isCollapsed = isSectionCollapsed
                    )
                }
            } else null
        ) { item, index ->
            sectionItemContent(item, index)
        }
    }
}

@Composable
private fun ExpandCollapseAction(onClick: () -> Unit, isCollapsed: Boolean = true) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(44.dp)
                .border(width = 1.dp, color = Color.LightGray, shape = CircleShape)
                .clickable(onClick = onClick, indication = RippleIndication(bounded = false)),
            alignment = Alignment.Center
        ) {
            Image(asset = if (isCollapsed) AppIcons.KeyboardArrowDown else AppIcons.KeyboardArrowUp)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = if (isCollapsed) "Show more" else "Show less",
            style = MaterialTheme.typography.caption
        )
    }
}