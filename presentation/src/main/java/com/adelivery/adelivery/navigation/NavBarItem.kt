package com.adelivery.adelivery.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import com.adelivery.adelivery.navigation.BarItem

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = "home"
        ),
        BarItem(
            title = "myPage",
            image = Icons.Filled.ShoppingCart,
            route = "myPage"
        )
    )
}