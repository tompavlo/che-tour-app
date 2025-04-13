package com.example.chernivtsiapp.data

import com.example.chernivtsiapp.R

object NavigatorItemsList {
    val navigatorsListItems = listOf(
        NavigatorItem(
            tab = Tabs.INFO,
            iconResIdDeselected = R.drawable.home,
            iconResIdSelected = R.drawable.home_fill,
            text = "Home"
        ),
        NavigatorItem(
            tab = Tabs.CAFE,
            iconResIdDeselected = R.drawable.cafe,
            iconResIdSelected = R.drawable.cafe_fill,
            text = "Cafes"
        ),
        NavigatorItem(
            tab = Tabs.RESTAURANT,
            iconResIdDeselected = R.drawable.restaurant_outline,
            iconResIdSelected = R.drawable.restaurant,
            text = "Restaurants"
        ),
        NavigatorItem(
            tab = Tabs.PARK,
            iconResIdDeselected = R.drawable.nature,
            iconResIdSelected = R.drawable.nature_fill,
            text = "Parks"
        ),
        NavigatorItem(
            tab = Tabs.SIGHTSEEING,
            iconResIdDeselected = R.drawable.sightseeing,
            iconResIdSelected = R.drawable.explore_fill,
            text = "Sightseeing"
        )
    )
}