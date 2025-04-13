package com.example.chernivtsiapp.ui

import com.example.chernivtsiapp.data.Location
import com.example.chernivtsiapp.data.Tabs

data class CheTourUiState(
    val currentTab: Tabs = Tabs.INFO,
    val currentLocation: Location? = null,
    val showingHomePage : Boolean = true
)