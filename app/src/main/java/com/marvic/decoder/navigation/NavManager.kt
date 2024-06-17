package com.marvic.decoder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marvic.decoder.views.HomeView
import com.marvic.decoder.views.details.DetailView

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomeView") {
        composable("HomeView") { HomeView(navController) }
        composable("DetailView") { DetailView("none", navController) }
    }
}