package com.marvic.decoder.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.marvic.decoder.viewModels.user.UserViewModel
import com.marvic.decoder.viewModels.userRegister.UserRegisterViewModel
import com.marvic.decoder.viewmodels.home.HomeViewModel
import com.marvic.decoder.views.details.DetailView
import com.marvic.decoder.views.home.HomeView
import com.marvic.decoder.views.splash.SplashScreen
import com.marvic.decoder.views.userRegister.UserRegisterView

@Composable
fun NavManager(userViewModel: UserViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "SplashScreen") {
        composable("HomeView") {
            val homeViewModel: HomeViewModel = viewModel()
            HomeView(navController, homeViewModel, userViewModel)
        }
        composable("UserRegisterView") {
            val userRegisterViewModel: UserRegisterViewModel = viewModel()
            UserRegisterView(userRegisterViewModel, userViewModel, navController)
        }
        composable("DetailView/{ingredientName}", arguments = listOf(
            navArgument("ingredientName") { type = NavType.StringType }
        )) {
            val ingredientName = it.arguments?.getString("ingredientName") ?: "none"
            DetailView(ingredientName, navController)
        }
        composable("SplashScreen") {
            SplashScreen(navController)
        }
    }
}