package com.example.chernivtsiapp.ui

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.chernivtsiapp.data.NavigationType

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface {
                val navController = rememberNavController()
                val cheTourViewModel: CheTourViewModel = viewModel()
                val cheTourUiState: CheTourUiState = cheTourViewModel.uiState.collectAsState().value
                val activity: Context = LocalContext.current as Activity
                val windowSize = calculateWindowSizeClass(this)
                if (windowSize.widthSizeClass == WindowWidthSizeClass.Expanded) {
                    CheTourExpandedScreens(
                        navController = navController,
                        cheTourViewModel = cheTourViewModel,
                        cheTourUiState = cheTourUiState,
                        activity = activity
                    )
                } else {
                    CheTourCompactMediumScreens(
                        navigationType = if (windowSize.widthSizeClass == WindowWidthSizeClass.Compact) NavigationType.BOTTOM
                        else NavigationType.SIDE_BAR_SMALL,
                        navController = navController,
                        cheTourViewModel = cheTourViewModel,
                        cheTourUiState = cheTourUiState,
                        activity = activity
                    )
                }
            }
        }
    }
}
