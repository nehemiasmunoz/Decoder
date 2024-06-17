package com.marvic.decoder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.marvic.decoder.views.HomeView
import com.marvic.decoder.views.details.DetailView

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomeView") {
        composable("HomeView") { HomeView(navController) }
        composable("DetailView/{ingredientName}", arguments = listOf(
            navArgument("ingredientName") { type = NavType.StringType }
        )) {
            val ingredientName = it.arguments?.getString("ingredientName") ?: "none"
            DetailView(ingredientName, navController)
        }
    }
}