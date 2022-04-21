package com.adelivery.adelivery.navigation

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object MyPage : NavRoutes("myPage")
}