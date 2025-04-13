package com.example.chernivtsiapp.ui

import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chernivtsiapp.R
import com.example.chernivtsiapp.data.Location
import com.example.chernivtsiapp.data.LocationProvider
import com.example.chernivtsiapp.ui.theme.ChernivtsiAppTheme
import com.example.chernivtsiapp.ui.theme.montserratRound

@Composable
fun LocationDetailsScreen(
    location: Location,
    context: Context,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(location.image),
            contentScale = ContentScale.FillWidth,
            contentDescription = stringResource(location.name),
            modifier = Modifier
                .clip(RoundedCornerShape(18.dp))
                .fillMaxWidth(fraction = 0.58F)
                .fillMaxHeight(fraction = 0.35F)
                .sizeIn(maxHeight = 400.dp)
        )
        Text(
            text = stringResource(location.description),
            fontFamily = montserratRound,
            modifier = Modifier.padding(
                horizontal = 4.dp,
                vertical = 16.dp
            )
        )
        HorizontalDivider(thickness = 2.dp)
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ) {
            if (location.rating != null) RatingBar(
                rating = location.rating,
                iconSize = 32.dp
            )
            if (location.price != null) PriceBar(
                price = location.price,
                iconWidth = 26.dp,
                iconHeight = 23.dp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        HorizontalDivider(thickness = 2.dp)
        if (location.workingHours != null) {
            Column {
                Row(modifier = Modifier.padding(top = 12.dp, bottom = 8.dp)) {
                    Icon(
                        imageVector = Icons.Rounded.Schedule,
                        contentDescription = null,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(stringResource(location.workingHours))
                }
                if(location.workingHoursAdditional!=null){
                    Text(text = stringResource(location.workingHoursAdditional),
                        modifier = Modifier.padding(start = 32.dp, bottom = 8.dp))
                }
            }
            HorizontalDivider(thickness = 2.dp)
        }
        LocationPlacementCard(
            location = location,
            context = context,
            modifier = Modifier.padding(vertical = 16.dp),
            fontSize = 22.sp,
            iconSize = 26.dp
        )

    }
}


@Composable
@Preview
fun LocationDetailsScreenPreview() {
    ChernivtsiAppTheme(dynamicColor = false) {
        Surface {
            LocationDetailsScreen(
                location = LocationProvider.caffesLocationList[2],
                context = LocalContext.current,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 8.dp, horizontal = 6.dp)
            )
        }
    }
}

@Composable
@Preview(widthDp = 700)
fun LocationDetailsScreenExpanded() {
    ChernivtsiAppTheme(dynamicColor = false) {
        Surface {
            LocationDetailsScreen(
                location = LocationProvider.caffesLocationList[2],
                context = LocalContext.current,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 16.dp, horizontal = 6.dp)
            )
        }
    }
}

