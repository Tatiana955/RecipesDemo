package com.example.recipesdemo.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.recipesdemo.ui.AppNavHost

@Composable
fun AppScreen() {
    Scaffold(
        content = {
            AppNavHost(
                navController = rememberNavController()
            )
        }
    )
}