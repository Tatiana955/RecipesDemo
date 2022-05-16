package com.example.recipesdemo.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.recipesdemo.ui.screens.edamamscreen.EdamamScreen
import com.example.recipesdemo.ui.screens.infoscreen.InfoScreen
import com.example.recipesdemo.util.Screen

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.EdamamScreen.route
    ) {
        composable(Screen.EdamamScreen.route) {
            EdamamScreen(
                onItemClick = {
                    navController.navigate(
                        Screen.InfoScreen.route + "/$it"
                    )
                }
            )
        }
        composable(Screen.InfoScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                }
            )
        ) {
            val id = remember {
                it.arguments?.getString("id")
            }
            InfoScreen(
                id = id
            )
        }
    }
}