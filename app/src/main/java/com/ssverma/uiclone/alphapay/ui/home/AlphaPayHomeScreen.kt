package com.ssverma.uiclone.alphapay.ui.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.ripple.RippleIndication
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import com.ssverma.uiclone.R
import com.ssverma.uiclone.alphapay.data.SectionActionData
import com.ssverma.uiclone.alphapay.ui.AppIcons
import com.ssverma.uiclone.alphapay.ui.core.ArrowButton
import com.ssverma.uiclone.alphapay.ui.core.Avatar
import com.ssverma.uiclone.alphapay.ui.core.VerticalSpacer

@Composable
fun AlphaPayHomeScreen(
    scrollState: ScrollState
) {
    val viewModel = viewModel<AlphaPayHomeViewModel>()

    Box {
        AlphaPayHeader()
        ScrollableColumn(scrollState = scrollState) {
            Spacer(modifier = Modifier.height(206.dp)) //TODO: think better approach
            Column(
                modifier = Modifier.drawShadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(topLeft = 12.dp, topRight = 12.dp)
                ).background(
                    color = Color.White
                )
            ) {
                HeaderBanner()
                HomeSection(
                    sectionTitle = "People",
                    items = viewModel.persons
                ) { item, index ->
                    SectionItem(
                        imageUrl = item.imageUrl,
                        title = item.name,
                        onClick = {},
                        isNotificationAvailable = index == 1
                    )
                }
                Divider(thickness = 0.5.dp, modifier = Modifier.padding(16.dp))
                HomeSection(
                    sectionTitle = "Business and bills",
                    sectionActionData = SectionActionData(
                        label = "Explore",
                        icon = AppIcons.ShoppingCart
                    ),
                    items = viewModel.businessUnits
                ) { item, index ->
                    SectionItem(imageUrl = item.imageUrl, title = item.name, onClick = {})
                }
                Divider(thickness = 0.5.dp, modifier = Modifier.padding(16.dp))
                HomeSection(
                    sectionTitle = "Promotions",
                    items = viewModel.promotions
                ) { item, index ->
                    SectionItem(imageUrl = item.imageUrl, title = item.name, onClick = {})
                }
                Spacer(modifier = Modifier.height(16.dp))
                ArrowButton(
                    onClick = {},
                    startIcon = AppIcons.Refresh,
                    text = "See all payment activity"
                )
                ArrowButton(
                    onClick = {},
                    startIcon = AppIcons.Home,
                    text = "Check account balance"
                )
                VerticalSpacer(height = 24.dp)
                InviteSection()
            }
        }
    }
}

@Composable
fun HeaderBanner() {
    Card(
        shape = MaterialTheme.shapes.medium.copy(CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, Color.LightGray),
        modifier = Modifier.padding(16.dp)
    ) {
        Row {
            Image(
                asset = imageResource(id = R.drawable.ic_car),
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .clip(CircleShape)
                    .size(32.dp)
            )
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(id = R.string.alpha_pay_game_banner_title),
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.weight(1f).padding(top = 16.dp)
                    )
                    IconButton(onClick = {}, modifier = Modifier.padding(end = 8.dp)) {
                        Icon(asset = Icons.Default.Close)
                    }
                }
                Text(
                    text = stringResource(id = R.string.alpha_pay_game_banner_description),
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(end = 16.dp, top = 4.dp)
                )
                TextButton(
                    onClick = {},
                    modifier = Modifier.align(Alignment.End)
                        .padding(bottom = 8.dp, end = 8.dp, top = 16.dp),
                ) {
                    Text(text = "Play now")
                }
            }
        }
    }
}

private const val profileImageUrl =
    "https://pbs.twimg.com/profile_images/1268911260592148480/3wli33oL_400x400.jpg"

@Composable
private fun AlphaPayTopBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .padding(top = 4.dp, start = 8.dp, end = 16.dp)
    ) {
        IconButton(onClick = {}) {
            Icon(asset = Icons.Default.Search)
        }
        Avatar(imageUrl = profileImageUrl)
    }
}

@Composable
private fun AlphaPayHeader() {
    Column {
        AlphaPayTopBar()
        AlphaPayLogo()
        Box(alignment = Alignment.BottomCenter) {
            Image(asset = imageResource(id = R.drawable.pay_illustration))
            EnterGameAction()
        }
    }
}

@Composable
private fun AlphaPayLogo() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            asset = imageResource(id = R.drawable.app_logo),
            modifier = Modifier.size(36.dp).padding(end = 8.dp)
        )
        Text(text = "Pay", style = MaterialTheme.typography.h6)
    }
}

@Composable
private fun EnterGameAction() {
    Surface(
        elevation = 4.dp,
        shape = RoundedCornerShape(percent = 50),
        modifier = Modifier.padding(bottom = 32.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.clickable(
                onClick = {},
                indication = RippleIndication(bounded = false)
            )
        ) {
            Image(
                asset = imageResource(id = R.drawable.ic_car),
                modifier = Modifier.size(32.dp).padding(start = 12.dp)
            )
            Text(
                text = "Enter game",
                style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Icon(asset = Icons.Outlined.KeyboardArrowRight, tint = MaterialTheme.colors.primary)
        }
    }
}

@Composable
private fun InviteSection() {
    Box {
        Image(asset = imageResource(id = R.drawable.refer_and_earn))
        Column(modifier = Modifier.padding(start = 16.dp, top = 16.dp)) {

            Text(text = "Invite your friends", style = MaterialTheme.typography.body1)
            VerticalSpacer(height = 4.dp)
            Text(
                text = "Get Rs. 101 after each friend's first payment",
                style = MaterialTheme.typography.caption
            )
            VerticalSpacer(height = 16.dp)
            TextButton(
                onClick = {},
                border = BorderStroke(width = 1.dp, color = Color.LightGray),
                shape = RoundedCornerShape(percent = 50),
                contentPadding = PaddingValues(
                    start = 20.dp,
                    end = 20.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
            ) {
                Text(text = "Invite", color = MaterialTheme.colors.onSurface)
            }
        }
    }
}