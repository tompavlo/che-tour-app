package com.example.chernivtsiapp.data

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.core.util.rangeTo
import com.example.chernivtsiapp.R

object LocationProvider {
    val caffesLocationList = listOf(
        Location(
            name = R.string.bacara,
            image = R.drawable.bacara,
            address = R.string.bacara_address,
            latitude = 48.29151140555888,
            longitude = 25.93278072940587,
            description = R.string.bacara_description,
            workingHours = R.string.bacara_working_hours,
            rating = 4.5,
            price = Pricing.EXPENSIVE
        ),

        Location(
            name = R.string.lviv_croissants,
            image = R.drawable.lvivcrousiant,
            address = R.string.lviv_croissants_address,
            latitude = 48.292451116376185,
            longitude = 25.933041047504613,
            description = R.string.lviv_croissants_description,
            workingHours = R.string.lviv_croissants_working_hours,
            rating = 4.5,
            price = Pricing.MODERATE
        ),

        Location(
            name = R.string.tvoya_mriya,
            image = R.drawable.mriya,
            address = R.string.tvoya_mriya_address,
            latitude = 48.287240537004664,
            longitude = 25.93860859215747,
            description = R.string.tvoya_mriya_description,
            workingHours = R.string.tvoya_mriya_working_hours,
            workingHoursAdditional = R.string.tvoya_mriya_working_hours_additional,
            rating = 4.5,
            price = Pricing.MODERATE
        ),

        Location(
            name = R.string.room_room,
            image = R.drawable.roomroom,
            address = R.string.room_room_address,
            latitude = 48.266725314223144,
            longitude = 25.939084287661483,
            description = R.string.room_room_description,
            workingHours = R.string.room_room_working_hours,
            rating = 3.5,
            price = Pricing.MODERATE
        ),
    )

    val restaurantsLocationList = listOf(
        Location(
            name = R.string.shosho,
            image = R.drawable.shosho,
            address = R.string.shosho_address,
            latitude = 48.292796247143926,
            longitude = 25.934592192371042,
            description = R.string.shosho_description,
            workingHours = R.string.shosho_working_hours_,
            workingHoursAdditional = R.string.shosho_working_hours_additional,
            rating = 4.5,
            price = Pricing.MODERATE
        ),

        Location(
            name = R.string.la_pasta,
            image = R.drawable.lapasta,
            address = R.string.la_pasta_address,
            latitude = 48.28952972638642,
            longitude = 25.936658716376957,
            description = R.string.la_pasta_description,
            workingHours = R.string.la_pasta_working_hours,
            rating = 4.5,
            price = Pricing.EXPENSIVE
        ),

        Location(
            name = R.string.kasha_maslom,
            image = R.drawable.kashamaslom,
            address = R.string.kasha_maslom_address,
            latitude = 48.269644632088415,
            longitude = 25.92834509873457,
            description = R.string.kasha_maslom_description,
            workingHours = R.string.kasha_maslom_working_hours,
            workingHoursAdditional = R.string.kasha_maslom_working_hours_additional,
            rating = 5.0,
            price = Pricing.CHEAP
        ),

        Location(
            name = R.string.fayno,
            image = R.drawable.fayno,
            address = R.string.fayno_location,
            latitude = 48.2892808834632,
            longitude = 25.93411268086292,
            description = R.string.fayno_description,
            workingHours = R.string.fayno_working_hours,
            rating = 4.5,
            price = Pricing.MODERATE
        ),

        Location(
            name = R.string.pronto_pizza,
            image = R.drawable.pronto,
            address = R.string.pronto_pizza_location,
            latitude = 48.26859560031113,
            longitude = 25.932562457930555,
            description = R.string.pronto_pizza_description,
            workingHours = R.string.pronto_pizza_working_hours,
            rating = 4.5,
            price = Pricing.MODERATE,
        )
    )

    val parksLocationList = listOf(
        Location(
            name = R.string.vyshyvanka_day_square,
            image = R.drawable.skverdnyavyshyvank,
            address = R.string.vyshyvanka_day_square_location,
            latitude = 48.28754697598415,
            longitude = 25.934701039894914,
            description = R.string.vyshyvanka_day_square_description,
            rating = 5.0
        ),

        Location(
            name = R.string.shevchenko_park,
            image = R.drawable.shevchenko,
            address = R.string.shevchenko_park_location,
            latitude = 48.281312811650196,
            longitude = 25.938392413614537,
            description = R.string.shevchenko_park_description,
            rating = 4.5
        ),

        Location(
            name = R.string.popivskyi_square,
            image = R.drawable.popivskyi,
            address = R.string.popiviskyi_square_location,
            latitude = 48.296033325478554,
            longitude = 25.925297141353795,
            description = R.string.popivskyi_square_description,
            rating = 5.0
        ),

        Location(
            name = R.string.park_zhovtnevyy,
            image = R.drawable.zovtnevyy,
            address = R.string.park_zhovtnevyy_location,
            latitude = 48.296033325478554,
            longitude = 25.925297141353795,
            description = R.string.park_zhovtnevyy_description,
            rating = 5.0
        )
    )

    val sightseeingLocations = listOf(
        Location(
            name = R.string.turkish_square,
            image = R.drawable.turkishsquare,
            address = R.string.turkish_square_location,
            latitude = 48.29448793359502,
            longitude = 25.939704860951018,
            description = R.string.turkish_square_description,
            rating = 4.5
        ),

        Location(
            name = R.string.kobylyanska_street,
            image = R.drawable.kobulyanska,
            address = R.string.kobylyanska_street_location,
            latitude = 48.291665937992306,
            longitude = 25.93550436081196,
            description = R.string.kobylyanska_street_description,
            rating = 5.0
        ),

        Location(
            name = R.string.chnu,
            image = R.drawable.chnu,
            address = R.string.chnu_location,
            latitude = 48.29719115583992,
            longitude = 25.924353678848945,
            description = R.string.chnu_description,
            rating = 5.0
        ),

        Location(
            name = R.string.filarmonii,
            image = R.drawable.filarmonii,
            address = R.string.filarmonii_location,
            latitude = 48.2947891389344,
            longitude = 25.93409631904316,
            description = R.string.filarmonii_description,
            rating = 5.0
        ),

        Location(
            name = R.string.teatrlana_square,
            image = R.drawable.teatralna,
            address = R.string.teatralna_location,
            latitude = 48.294955157878725,
            longitude = 25.934317222433894,
            description = R.string.teatralna_description,
            rating = 5.0
        )
    )
}