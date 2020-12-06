package com.ssverma.uiclone.alphapay.ui.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun <T> Grid(
    items: List<T> = listOf(),
    spanCount: Int = 4,
    horizontalSpacing: Dp = 8.dp,
    leading: @Composable ((Int) -> Unit)? = null,
    itemContent: @Composable (T, Int) -> Unit
) {
    val chunkedList = items.chunked(spanCount)

    Column(
        modifier = Modifier.padding(horizontal = horizontalSpacing)
    ) {
        chunkedList.forEachIndexed { row, rowItems ->
            Row {
                rowItems.forEachIndexed { rowItemIndex, item ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        alignment = Alignment.Center
                    ) {
                        itemContent(item, row * spanCount + rowItemIndex)
                    }
                    if (row == chunkedList.lastIndex && rowItemIndex == rowItems.lastIndex) {
                        for (i in 0 until spanCount - rowItems.size) {
                            if (i == 0 && leading != null) {
                                Box(
                                    modifier = Modifier.weight(1f).padding(8.dp),
                                    alignment = Alignment.Center
                                ) {
                                    leading(row * spanCount + rowItemIndex)
                                }
                            } else {
                                Box(modifier = Modifier.weight(1f).padding(8.dp))
                            }
                        }
                    }
                }
            }
        }
        /*Add leading as new row if previous row is full*/
        if (chunkedList[chunkedList.lastIndex].size == spanCount && leading != null) {
            Row {
                Box(
                    modifier = Modifier.weight(1f).padding(8.dp),
                    alignment = Alignment.Center
                ) {
                    leading(items.size)
                }
            }
        }
    }
}