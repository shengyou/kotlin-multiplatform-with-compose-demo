package io.kraftsman.multiplatform.functions

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import io.kraftsman.multiplatform.data.Option

val optionsList: ArrayList<Option> = ArrayList()
fun prepareOptionsData() {

    val appIcons = Icons.Outlined

    optionsList.add(
        Option(
            icon = appIcons.Person,
            title = "Account",
            subTitle = "Manage your account"
        )
    )

    optionsList.add(
        Option(
            icon = appIcons.FavoriteBorder,
            title = "Wishlist",
            subTitle = "Items you saved"
        )
    )

    optionsList.add(
        Option(
            icon = appIcons.CheckCircle,
            title = "Offers and Coupons",
            subTitle = "Offers and coupon codes for you"
        )
    )

    optionsList.add(
        Option(
            icon = appIcons.ShoppingCart,
            title = "Orders",
            subTitle = "Orders history"
        )
    )

    optionsList.add(
        Option(
            icon = appIcons.LocationOn,
            title = "Addresses",
            subTitle = "Your saved addresses"
        )
    )

    optionsList.add(
        Option(
            icon = appIcons.AccountCircle,
            title = "Saved Cards",
            subTitle = "Your saved debit/credit cards"
        )
    )

    optionsList.add(
        Option(
            icon = appIcons.Settings,
            title = "Settings",
            subTitle = "App notification settings"
        )
    )

    optionsList.add(
        Option(
            icon = appIcons.Email,
            title = "Help Center",
            subTitle = "FAQs and customer support"
        )
    )
}
