package com.example.recipesdemo.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.recipesdemo.ui.screens.detailsrecipescreen.DetailsRecipeScreen
import com.example.recipesdemo.ui.screens.edamamscreen.EdamamScreen
import com.example.recipesdemo.ui.screens.infoscreen.InfoScreen
import com.example.recipesdemo.ui.screens.savedrecipescreen.SavedRecipeScreen
import com.example.recipesdemo.ui.screens.webpagesscreen.WebPagesScreen
import com.example.recipesdemo.util.Screen

@ExperimentalFoundationApi
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
        composable(Screen.SavedRecipeScreen.route) {
            SavedRecipeScreen(
                onClickDetails = {
                    navController.navigate(
                        Screen.DetailsRecipeScreen.route + "/$it"
                    )
                }
            )
        }
        composable(Screen.DetailsRecipeScreen.route + "/{prKey}",
            arguments = listOf(
                navArgument("prKey") {
                    type = NavType.StringType
                }
            )
        ) {
            val prKey = remember {
                it.arguments?.getString("prKey")
            }
            DetailsRecipeScreen(
                prKey = prKey,
                onClickInfo = {
                    navController.navigate(
                        Screen.InfoScreen.route + "/$it"
                    )
                },
                onClickInstructions = {
                    navController.navigate(
                        Screen.WebPagesScreen.route + "/$it"
                    )
                }
            )
        }
        composable(Screen.WebPagesScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                }
            )
        ) {
            val id = remember {
                it.arguments?.getString("id")
            }
            WebPagesScreen(
                id = id
            )
        }
    }
}