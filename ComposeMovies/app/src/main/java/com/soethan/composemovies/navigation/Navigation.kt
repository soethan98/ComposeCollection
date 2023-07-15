package com.soethan.composemovies.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.soethan.composemovies.screens.DetailsScreen
import com.soethan.composemovies.screens.HomeScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(onNavigateToDetail = {navController.navigate(Screen.Details.route)})
        }

        composable(Screen.Details.route) {
            DetailsScreen()
        }
    }
}