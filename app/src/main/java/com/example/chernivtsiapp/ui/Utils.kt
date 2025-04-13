package com.example.chernivtsiapp.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.StarHalf
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chernivtsiapp.R
import com.example.chernivtsiapp.data.Location
import com.example.chernivtsiapp.data.LocationProvider
import com.example.chernivtsiapp.data.Pricing
import com.example.chernivtsiapp.ui.theme.ChernivtsiAppTheme
import com.example.chernivtsiapp.ui.theme.secondaryContainerLight

@Composable
fun LocationCard(
    context: Context,
    selected: Boolean,
    location: Location,
    onClick: (Location) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable{
                onClick(location)
            }
            .sizeIn(maxHeight = 140.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (selected)
                contentColorFor(secondaryContainerLight)

            else
                MaterialTheme.colorScheme.secondaryContainer,

            contentColor = if (selected) MaterialTheme.colorScheme.secondaryContainer
            else contentColorFor(secondaryContainerLight)
            )
    ) {
        Row {
            Image(
                painter = painterResource(location.image),
                contentDescription = stringResource(location.name),
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.42f)
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(start = 4.dp)) {
                Text(
                    text = stringResource(location.name),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 2.dp)
                )
                if (location.rating != null) RatingBar(
                    rating = location.rating,
                    modifier = Modifier.padding(top = 4.dp, bottom = 6.dp)
                )
                if (location.price != null)
                    PriceBar(
                        price = location.price
                    )
                Spacer(modifier = Modifier.weight(1f))
                LocationPlacementCard(
                    location = location,
                    context = context,
                )

            }
        }
    }
}

private fun openLocationChooser(
    latitude: Double,
    longitude: Double,
    context: Context
) {
    val geoUri = "geo:$latitude,$longitude?q=$latitude,$longitude(Location of this place)"
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))
    val chooser = Intent.createChooser(intent, "Choose an app to open the location")
    context.startActivity(chooser)
}

@Composable
fun LocationPlacementCard(
    location: Location,
    context: Context,
    color: CardColors = CardColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.secondaryContainer,
        disabledContentColor = Color.Blue,
        disabledContainerColor = Color.Yellow
    ),
    fontSize: TextUnit = 12.sp,
    iconSize: Dp = 24.dp,
    modifier: Modifier = Modifier
) {
    Card(
        colors = color,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .clickable(
                onClick = {
                    openLocationChooser(
                        latitude = location.latitude,
                        longitude = location.longitude,
                        context = context
                    )
                }
            )
            .padding(start = 2.dp, bottom = 4.dp, end = 12.dp)
            .wrapContentWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(all = 2.dp)
                .padding(end = 4.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.LocationOn,
                contentDescription = null,
                modifier = Modifier.size(iconSize)
            )
            Text(
                text = stringResource(location.address),
                fontSize = fontSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun RatingBar(
    rating: Double,
    iconSize: Dp = 24.dp,
    modifier: Modifier = Modifier
) {
    val isHalf = (rating % 1) != 0.0
    Row(modifier = modifier) {
        for (index in 1..5) {
            Icon(
                contentDescription = null,
                tint = Color(210, 183, 0, 255),
                imageVector = when {
                    index <= rating -> Icons.Rounded.Star
                    index == rating.toInt() + 1 && isHalf -> Icons.AutoMirrored.Rounded.StarHalf
                    else -> Icons.Rounded.StarOutline
                },
                modifier = Modifier.size(iconSize)
            )
        }
    }
}

@Composable
fun PriceBar(
    price: Pricing,
    iconHeight: Dp = 20.dp,
    iconWidth: Dp = 24.dp,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        for (index in 1..3) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.hryvna),
                contentDescription = null,
                tint = if (index <= price.value) {
                    Color(0, 144, 16)
                } else {
                    Color(200, 200, 200)
                },
                modifier = Modifier
                    .size(height = iconHeight, width = iconWidth)


            )
        }
    }
}



@Preview
@Composable
fun MyApp() {
    ChernivtsiAppTheme(dynamicColor = false) {
        Surface {
            Column(modifier = Modifier.fillMaxSize()) {
                val context = LocalContext.current
                LocationProvider.restaurantsLocationList.forEach {
                    LocationCard(
                        context = context,
                        selected = it == LocationProvider.sightseeingLocations.first(),
                        location = it,
                        onClick = {},
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Preview(widthDp = 700)
@Composable
fun MyAppWide() {
    ChernivtsiAppTheme(dynamicColor = false) {
        Surface {
            Column(modifier = Modifier.fillMaxSize()) {
                val context = LocalContext.current
                LocationProvider.restaurantsLocationList.forEach {
                    LocationCard(
                        context = context,
                        selected = it == LocationProvider.sightseeingLocations.first(),
                        location = it,
                        onClick = {},
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}







