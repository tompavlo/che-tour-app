package com.example.chernivtsiapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.chernivtsiapp.R

val valeraRound = FontFamily(
    Font(R.font.varelaround_regular)
)

@OptIn(ExperimentalTextApi::class)
val montserratRound = FontFamily(
    Font(
        R.font.montserrat_variablefont_wght,
        variationSettings = FontVariation.Settings(
            FontVariation.weight(500),
        )
    )
)

val AppTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = montserratRound,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

