package com.example.chernivtsiapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.chernivtsiapp.R
import com.example.chernivtsiapp.data.NavigatorItem
import com.example.chernivtsiapp.data.Tabs
import com.example.chernivtsiapp.ui.theme.valeraRound


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    canGoBack: Boolean,
    goBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                stringResource(R.string.cooperative_name),
                fontFamily = valeraRound,
                fontSize = 40.sp,

                )
        },
        modifier = modifier,
        navigationIcon = {
            if (canGoBack) {
                IconButton(onClick = { goBack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.backArrow)
                    )
                }
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}

@Composable
fun SideNavigationBig(
    navigationItemContentList: List<NavigatorItem>,
    currentTab: Tabs,
    onTabPressed: (Tabs) -> Unit,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.cooperative_name),
            fontFamily = valeraRound,
            fontSize = 28.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )
        navigationItemContentList.forEach {
            NavigationDrawerItem(
                selected = currentTab == it.tab,
                onClick = {
                    onTabPressed(it.tab)
                    navController.navigate(it.tab.name)
                },
                icon = {
                    Icon(
                        imageVector = if (currentTab == it.tab) {
                            ImageVector.vectorResource(it.iconResIdSelected)
                        } else {
                            ImageVector.vectorResource(it.iconResIdDeselected)
                        },
                        contentDescription = it.text
                    )
                },
                label = {
                    Text(it.text)
                },
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}

@Composable
fun SideNavigationSmall(
    navigationItemContentList: List<NavigatorItem>,
    currentTab: Tabs,
    onTabPressed: (Tabs) -> Unit,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationRail(modifier) {
        navigationItemContentList.forEach {
            NavigationRailItem(
                selected = currentTab == it.tab,
                onClick = {
                    onTabPressed(it.tab)
                    navController.navigate(it.tab.name)
                },
                icon = {
                    Icon(
                        imageVector = if (currentTab == it.tab) {
                            ImageVector.vectorResource(it.iconResIdSelected)
                        } else {
                            ImageVector.vectorResource(it.iconResIdDeselected)
                        },
                        contentDescription = it.text
                    )
                },
                label = {
                    Text(it.text)
                }
            )
        }
    }
}

@Composable
fun BottomAppNavigation(
    currentTab: Tabs,
    onTabPressed: (Tabs) -> Unit,
    navigationItemContentList: List<NavigatorItem>,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentTab == navItem.tab,
                onClick = {
                    onTabPressed(navItem.tab)
                    navController.navigate(navItem.tab.name)
                },
                icon = {
                    Icon(
                        imageVector = if (currentTab == navItem.tab) {
                            ImageVector.vectorResource(navItem.iconResIdSelected)
                        } else {
                            ImageVector.vectorResource(navItem.iconResIdDeselected)
                        },
                        contentDescription = navItem.text
                    )
                }
            )
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(stringResource(R.string.home_screen1))
        Image(
            painter = painterResource(R.drawable.chernivtsi),
            contentDescription = "City",
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(stringResource(R.string.home_screen2))
    }
}

@Preview
@Composable
fun BarPreview() {

}