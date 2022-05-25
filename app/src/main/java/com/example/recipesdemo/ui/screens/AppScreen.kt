package com.example.recipesdemo.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.recipesdemo.ui.AppNavHost
import com.example.recipesdemo.ui.components.AppDrawer

@ExperimentalFoundationApi
@Composable
fun AppScreen() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val navController = rememberNavController()
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            AppDrawer(
                scaffoldState = scaffoldState,
                navController = navController
            )
        },
        content = {
            AppNavHost(
                navController = navController
            )
        }
    )
}