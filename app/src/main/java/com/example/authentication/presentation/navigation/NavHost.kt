package com.example.authentication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.authentication.presentation.views.HomeView
import com.example.authentication.presentation.views.LoginView
import com.example.authentication.presentation.views.OnBoardingView
import com.example.authentication.presentation.views.SignUpView


@Composable
fun NavigationHost() {

    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = Route.OnBoarding.route
    ) {
        composable(Route.OnBoarding.route) {
            OnBoardingView(navHostController = navController)
        }
        composable(Route.Login.route) {
            LoginView(navHostController = navController)
        }
        composable(Route.Signup.route) {
            SignUpView(navHostController = navController)
        }

        composable(Route.HomeView.route) {
            HomeView(navHostController = navController)
        }
    }
}

