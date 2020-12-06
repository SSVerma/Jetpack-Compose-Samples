package com.ssverma.uiclone.alphapay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.ssverma.uiclone.alphanews.applyLightStatusAndNavigationBars
import com.ssverma.uiclone.alphanews.updateStatusBarColor
import com.ssverma.uiclone.alphapay.ui.AppIcons
import com.ssverma.uiclone.alphapay.ui.home.AlphaPayHomeScreen
import com.ssverma.uiclone.alphapay.ui.theme.AlphaPayTheme

class AlphaPayHomeActivity : AppCompatActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        updateStatusBarColor(android.R.color.white)
        applyLightStatusAndNavigationBars()
        super.onCreate(savedInstanceState)
        setContent {
            AlphaPayTheme {
                val scrollState = rememberScrollState()
                rememberLazyListState()

                Scaffold(
                    floatingActionButton = {
                        AnimatedVisibility(
                            modifier = Modifier.background(color = Color.Transparent),
                            visible = scrollState.value <= scrollState.maxValue - 100,
                            enter = slideInVertically(initialOffsetY = { 200 }),
                            exit = slideOutVertically(targetOffsetY = { 200 }),
                            content = NewPaymentAction
                        )
                    },
                    floatingActionButtonPosition = FabPosition.Center
                ) {
                    AlphaPayHomeScreen(scrollState)
                }
            }
        }
    }
}

private val NewPaymentAction: @Composable () -> Unit = {
    FloatingActionButton(
        onClick = {},
        modifier = Modifier.preferredHeight(48.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                asset = AppIcons.Add,
                modifier = Modifier.padding(start = 16.dp, end = 8.dp)
            )
            Text(text = "New payment", modifier = Modifier.padding(end = 16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    AlphaPayTheme {
        AlphaPayHomeScreen(rememberScrollState())
    }
}