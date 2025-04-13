package com.example.chernivtsiapp.ui

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.chernivtsiapp.data.Location
import com.example.chernivtsiapp.data.Tabs
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CheTourViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CheTourUiState())
    val uiState: StateFlow<CheTourUiState> = _uiState


    fun updateCurrentTab(tab: Tabs) {
        _uiState.update {
            it.copy(
                currentTab = tab,
                currentLocation = null,
                showingHomePage = true
            )
        }
    }

    fun cardClicked(location: Location) {
        _uiState.update {
            it.copy(
                showingHomePage = uiState.value.currentLocation == location,
                currentLocation = if (uiState.value.currentLocation == location) null
                else location,
            )
        }
    }

    fun clickedBack(navController: NavHostController) {
        if (navController.previousBackStackEntry != null && uiState.value.showingHomePage) {
            navController.popBackStack()
            val previousRoute = navController.currentBackStackEntry?.destination?.route
            val previousTab = previousRoute?.let { Tabs.valueOf(it) } ?: Tabs.INFO

            _uiState.update {
                it.copy(
                    showingHomePage = true,
                    currentLocation = null,
                    currentTab = previousTab
                )
            }
        } else
            _uiState.update {
                it.copy(
                    showingHomePage = true,
                    currentLocation = null,
                )
            }
    }


}