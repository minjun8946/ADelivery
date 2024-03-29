package com.adelivery.adelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Shop
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adelivery.adelivery.home.Home
import com.adelivery.adelivery.mypage.MyPage
import com.adelivery.adelivery.navigation.BottomNavigationBar
import com.adelivery.adelivery.navigation.NavRoutes
import com.adelivery.adelivery.ui.theme.ADeliveryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ADeliveryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("ADelivery", color = Color.Black) },
                backgroundColor = Color.White,
                navigationIcon = {
                    Icon(
                        modifier = Modifier.padding(4.dp),
                        imageVector = Icons.Filled.Shop,
                        contentDescription = "Main",
                        tint = Color.Black
                    )
                })
        },
        content = { NavigationHost(navController = navController) },
        bottomBar = { BottomNavigationBar(navController = navController) }
    )
}

@Composable
fun NavigationHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route,
        modifier = Modifier.background(Color.White)
    ) {
        composable(NavRoutes.Home.route) {
            Home()
        }

        composable(NavRoutes.MyPage.route) {
            MyPage()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ADeliveryTheme {
        MainScreen()
    }
}