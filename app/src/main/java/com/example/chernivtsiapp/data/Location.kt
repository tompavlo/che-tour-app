package com.example.chernivtsiapp.data

data class Location(
    val name: Int,
    val image: Int,
    val address: Int,
    val latitude: Double,
    val longitude: Double,
    val description: Int,
    val workingHours: Int? = null,
    val workingHoursAdditional: Int? = null,
    val rating: Double? = null,
    val price: Pricing? = null,
)
