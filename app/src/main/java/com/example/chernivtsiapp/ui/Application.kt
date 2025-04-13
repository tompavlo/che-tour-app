package com.example.chernivtsiapp.ui

import android.app.Activity
import android.content.Context
import android.view.WindowInsetsController
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.privacysandbox.tools.core.model.Type
import com.example.chernivtsiapp.data.Location
import com.example.chernivtsiapp.data.LocationProvider
import com.example.chernivtsiapp.data.NavigationType
import com.example.chernivtsiapp.data.NavigatorItemsList
import com.example.chernivtsiapp.data.Tabs
import com.example.chernivtsiapp.ui.theme.ChernivtsiAppTheme

@Composable
fun CheTourCompactMediumScreens(
    navigationType: NavigationType,
    navController: NavHostController,
    cheTourViewModel: CheTourViewModel,
    cheTourUiState: CheTourUiState,
    activity: Context
) {
    ChernivtsiAppTheme {
        Scaffold(
            topBar = {
                AnimatedVisibility(
                    visible = navigationType == NavigationType.BOTTOM ||
                            (navigationType == NavigationType.SIDE_BAR_SMALL && !cheTourUiState.showingHomePage)
                ) {
                    AppBar(
                        canGoBack = !cheTourUiState.showingHomePage,
                        goBack = { cheTourViewModel.clickedBack(navController) })
                }
            },

            bottomBar = {
                if (navigationType == NavigationType.BOTTOM) {
                    BottomAppNavigation(
                        currentTab = cheTourUiState.currentTab,
                        onTabPressed = { tab: Tabs -> cheTourViewModel.updateCurrentTab(tab) },
                        navigationItemContentList = NavigatorItemsList.navigatorsListItems,
                        navController = navController
                    )
                }
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->

            NavHost(
                navController = navController,
                startDestination = Tabs.INFO.name
            ) {
                composable(route = Tabs.INFO.name) {
                    HomeScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(horizontal = 8.dp)
                            .padding(top = 8.dp)
                            .padding(
                                start = if (navigationType == NavigationType.SIDE_BAR_SMALL)
                                    84.dp else 0.dp
                            )
                    )
                }
                composable(route = Tabs.CAFE.name) {
                    if (cheTourUiState.showingHomePage) {
                        Column(
                            modifier = Modifier
                                .padding(innerPadding)
                                .padding(
                                    start = if (navigationType == NavigationType.SIDE_BAR_SMALL)
                                        84.dp else 0.dp
                                )
                                .verticalScroll(rememberScrollState())
                        ) {
                            LocationProvider.caffesLocationList.forEach {
                                LocationCard(
                                    location = it,
                                    context = activity,
                                    selected = false,
                                    onClick = { location: Location ->
                                        cheTourViewModel.cardClicked(location)
                                    },
                                    modifier = Modifier.padding(top = 12.dp)
                                )
                            }
                        }
                    } else {
                        LocationDetailsScreen(
                            location = cheTourUiState.currentLocation!!,
                            context = activity,
                            modifier = Modifier
                                .padding(innerPadding)
                                .padding(top = 8.dp)

                        )
                    }
                }
                composable(route = Tabs.RESTAURANT.name) {
                    if (cheTourUiState.showingHomePage) {
                        Column(
                            modifier = Modifier
                                .padding(innerPadding)
                                .padding(
                                    start = if (navigationType == NavigationType.SIDE_BAR_SMALL)
                                        84.dp else 0.dp
                                )
                                .verticalScroll(rememberScrollState())
                        ) {
                            LocationProvider.restaurantsLocationList.forEach {
                                LocationCard(
                                    location = it,
                                    context = activity,
                                    selected = false,
                                    onClick = { location: Location ->
                                        cheTourViewModel.cardClicked(location)
                                    },
                                    modifier = Modifier.padding(top = 12.dp)
                                )
                            }
                        }
                    } else {
                        LocationDetailsScreen(
                            location = cheTourUiState.currentLocation!!,
                            context = activity,
                            modifier = Modifier
                                .padding(innerPadding)
                                .padding(top = 8.dp)
                        )
                    }
                }
                composable(route = Tabs.PARK.name) {
                    if (cheTourUiState.showingHomePage) {
                        Column(
                            modifier = Modifier
                                .padding(innerPadding)
                                .padding(
                                    start = if (navigationType == NavigationType.SIDE_BAR_SMALL)
                                        84.dp else 0.dp
                                )
                                .verticalScroll(rememberScrollState())
                        ) {
                            LocationProvider.parksLocationList.forEach {
                                LocationCard(
                                    location = it,
                                    context = activity,
                                    selected = false,
                                    onClick = { location: Location ->
                                        cheTourViewModel.cardClicked(location)
                                    },
                                    modifier = Modifier.padding(top = 12.dp)
                                )
                            }
                        }
                    } else {
                        LocationDetailsScreen(
                            location = cheTourUiState.currentLocation!!,
                            context = activity,
                            modifier = Modifier
                                .padding(innerPadding)
                                .padding(top = 8.dp)
                        )
                    }
                }
                composable(route = Tabs.SIGHTSEEING.name) {
                    if (cheTourUiState.showingHomePage) {
                        Column(
                            modifier = Modifier
                                .padding(innerPadding)
                                .verticalScroll(rememberScrollState())
                        ) {
                            LocationProvider.sightseeingLocations.forEach {
                                LocationCard(
                                    location = it,
                                    context = activity,
                                    selected = false,
                                    onClick = { location: Location ->
                                        cheTourViewModel.cardClicked(location)
                                    },
                                    modifier = Modifier.padding(top = 12.dp)
                                )
                            }
                        }
                    } else {
                        LocationDetailsScreen(
                            location = cheTourUiState.currentLocation!!,
                            context = activity,
                            modifier = Modifier
                                .padding(innerPadding)
                                .padding(top = 8.dp)
                        )
                    }
                }
            }

            if (navigationType == NavigationType.SIDE_BAR_SMALL && cheTourUiState.showingHomePage)
                SideNavigationSmall(
                    currentTab = cheTourUiState.currentTab,
                    onTabPressed = { tab: Tabs -> cheTourViewModel.updateCurrentTab(tab) },
                    navController = navController,
                    navigationItemContentList = NavigatorItemsList.navigatorsListItems,
                    modifier = Modifier.padding(innerPadding)
                )
            BackHandler {
                cheTourViewModel.clickedBack(navController)
            }
        }
    }
}

@Composable
fun CheTourExpandedScreens(
    navController: NavHostController,
    cheTourViewModel: CheTourViewModel,
    cheTourUiState: CheTourUiState,
    activity: Context
) {
    LaunchedEffect(Unit) {
        (activity as? Activity)?.window?.let { window ->
            WindowCompat.setDecorFitsSystemWindows(window, false)

            window.insetsController?.let { controller ->
                controller.hide(WindowInsetsCompat.Type.systemBars())
                controller.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }
    }
    ChernivtsiAppTheme {
        PermanentNavigationDrawer(drawerContent = {
            PermanentDrawerSheet(
                Modifier
                    .width(240.dp)
            ) {
                SideNavigationBig(
                    navigationItemContentList = NavigatorItemsList.navigatorsListItems,
                    currentTab = cheTourUiState.currentTab,
                    onTabPressed = { tab: Tabs -> cheTourViewModel.updateCurrentTab(tab) },
                    navController = navController,
                    modifier = Modifier
                        .wrapContentWidth()
                        .fillMaxHeight()
                        .padding(WindowInsets.safeDrawing.asPaddingValues())
                        .padding(top = 12.dp)

                )
            }
        }) {

            NavHost(
                navController = navController,
                startDestination = Tabs.INFO.name
            ) {

                composable(route = Tabs.INFO.name) {
                    HomeScreen(
                        modifier = Modifier
                            .padding(WindowInsets.safeDrawing.asPaddingValues())
                            .padding(horizontal = 8.dp)
                            .padding(top = 8.dp)
                    )
                }
                composable(route = Tabs.CAFE.name) {
                    Row(
                        modifier = Modifier
                            .padding(WindowInsets.safeDrawing.asPaddingValues())
                            .padding(horizontal = 8.dp)
                            .padding(top = 8.dp)

                    ) {
                        Column(
                            Modifier
                                .fillMaxWidth(0.5F)
                                .verticalScroll(rememberScrollState())
                        ) {
                            LocationProvider.caffesLocationList.forEach {
                                LocationCard(
                                    context = activity,
                                    selected = cheTourUiState.currentLocation == it,
                                    location = it,
                                    onClick = { location: Location ->
                                        cheTourViewModel.cardClicked(location)
                                    },
                                    modifier = Modifier.padding(bottom = 12.dp)
                                )
                            }
                        }
                        cheTourUiState.currentLocation?.let {
                            LocationDetailsScreen(
                                location = it,
                                context = activity,
                                modifier = Modifier.padding(horizontal = 8.dp)

                            )
                        }
                    }
                }
                composable(route = Tabs.RESTAURANT.name) {
                    Row(
                        modifier = Modifier
                            .padding(WindowInsets.safeDrawing.asPaddingValues())
                            .padding(horizontal = 8.dp)
                            .padding(top = 8.dp)

                    ) {
                        Column(
                            Modifier
                                .fillMaxWidth(0.5F)
                                .verticalScroll(rememberScrollState())
                        ) {
                            LocationProvider.restaurantsLocationList.forEach {
                                LocationCard(
                                    context = activity,
                                    selected = cheTourUiState.currentLocation == it,
                                    location = it,
                                    onClick = { location: Location ->
                                        cheTourViewModel.cardClicked(location)
                                    },
                                    modifier = Modifier.padding(bottom = 12.dp)
                                )
                            }
                        }
                        cheTourUiState.currentLocation?.let {
                            LocationDetailsScreen(
                                location = it,
                                context = activity,
                                modifier = Modifier.padding(horizontal = 8.dp)

                            )
                        }
                    }
                }
                composable(route = Tabs.PARK.name) {
                    Row(
                        modifier = Modifier
                            .padding(WindowInsets.safeDrawing.asPaddingValues())
                            .padding(horizontal = 8.dp)
                            .padding(top = 8.dp)

                    ) {
                        Column(
                            Modifier
                                .fillMaxWidth(0.5F)
                                .verticalScroll(rememberScrollState())
                        ) {
                            LocationProvider.parksLocationList.forEach {
                                LocationCard(
                                    context = activity,
                                    selected = cheTourUiState.currentLocation == it,
                                    location = it,
                                    onClick = { location: Location ->
                                        cheTourViewModel.cardClicked(location)
                                    },
                                    modifier = Modifier.padding(bottom = 12.dp)
                                )
                            }
                        }
                        cheTourUiState.currentLocation?.let {
                            LocationDetailsScreen(
                                location = it,
                                context = activity,
                                modifier = Modifier.padding(horizontal = 8.dp)

                            )
                        }
                    }
                }
                composable(route = Tabs.SIGHTSEEING.name) {
                    Row(
                        modifier = Modifier
                            .padding(WindowInsets.safeDrawing.asPaddingValues())
                            .padding(horizontal = 8.dp)
                            .padding(top = 8.dp)

                    ) {
                        Column(
                            Modifier
                                .fillMaxWidth(0.5F)
                                .verticalScroll(rememberScrollState())
                        ) {
                            LocationProvider.sightseeingLocations.forEach {
                                LocationCard(
                                    context = activity,
                                    selected = cheTourUiState.currentLocation == it,
                                    location = it,
                                    onClick = { location: Location ->
                                        cheTourViewModel.cardClicked(location)
                                    },
                                    modifier = Modifier.padding(bottom = 12.dp)
                                )
                            }
                        }
                        cheTourUiState.currentLocation?.let {
                            LocationDetailsScreen(
                                location = it,
                                context = activity,
                                modifier = Modifier.padding(horizontal = 8.dp)

                            )
                        }
                    }
                }
            }
            BackHandler {
                cheTourViewModel.clickedBack(navController)
            }

        }
    }
}