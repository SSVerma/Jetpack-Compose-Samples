package com.ssverma.uiclone.alphanews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.ui.tooling.preview.Preview
import com.ssverma.uiclone.R
import com.ssverma.uiclone.alphanews.navigation.BottomNavScreen
import com.ssverma.uiclone.alphanews.ui.AlphaNewsTheme
import com.ssverma.uiclone.alphanews.ui.following.FollowingScreen
import com.ssverma.uiclone.alphanews.ui.headlines.HeadlinesScreen
import com.ssverma.uiclone.alphanews.ui.home.HomeScreen
import com.ssverma.uiclone.alphanews.ui.newsstand.NewsStandScreen
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        updateStatusBarColor(android.R.color.white)
        updateNavigationBarColor(android.R.color.white)
        applyLightStatusAndNavigationBars()
        super.onCreate(savedInstanceState)
        setContent {
            AlphaNewsTheme {
                val scaffoldState = rememberScaffoldState()
                val coroutineScope = rememberCoroutineScope()
                val navController = rememberNavController()

                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        TopAppBar {
                            IconButton(
                                onClick = {
                                    coroutineScope.launch {
                                        scaffoldState.snackbarHostState.showSnackbar(
                                            message = "Search icon clicked"
                                        )
                                    }
                                },
                                modifier = Modifier.align(Alignment.CenterVertically)
                            ) {
                                Icon(asset = Icons.Default.Search)
                            }
                            Row(
                                modifier = Modifier.align(Alignment.CenterVertically),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    asset = imageResource(id = R.drawable.app_logo),
                                    modifier = Modifier.size(32.dp).padding(end = 8.dp)
                                )
                                Text(
                                    text = "News",
                                    style = MaterialTheme.typography.h6
                                )
                            }
                            IconButton(
                                onClick = {},
                                modifier = Modifier.align(Alignment.CenterVertically)
                            ) {
                                Icon(asset = Icons.Default.AccountCircle)
                            }
                        }
                    },
                    bottomBar = {
                        MainBottomNavigation(navController)
                    }
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = BottomNavScreen.Home.route
                    ) {
                        composable(BottomNavScreen.Home.route) {
                            HomeScreen()
                        }
                        composable(BottomNavScreen.Headlines.route) {
                            HeadlinesScreen()
                        }
                        composable(BottomNavScreen.Following.route) {
                            FollowingScreen()
                        }
                        composable(BottomNavScreen.NewsStand.route) {
                            NewsStandScreen()
                        }
                    }
                }
            }
        }
    }

    private val bottomNavItems = listOf(
        BottomNavScreen.Home,
        BottomNavScreen.Headlines,
        BottomNavScreen.Following,
        BottomNavScreen.NewsStand
    )

    @Composable
    private fun MainBottomNavigation(navController: NavHostController) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

        BottomNavigation {
            bottomNavItems.forEach {
                BottomNavigationItem(
                    icon = {
                        Icon(asset = it.icon)
                    },
                    label = {
                        Text(text = stringResource(id = it.labelRes))
                    },
                    selected = it.route == currentRoute,
                    selectedContentColor = MaterialTheme.colors.secondary,
                    unselectedContentColor = AmbientContentColor.current.copy(alpha = ContentAlpha.medium),
                    onClick = {
                        if (it.route != currentRoute) {
                            navController.navigate(it.route)
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AlphaNewsTheme {
        HomeScreen()
    }
}