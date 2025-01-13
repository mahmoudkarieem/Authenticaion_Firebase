package com.example.authentication.presentation.navigation

sealed class Route(val route:String){
    object Login:Route("Login View")
    object Signup:Route("SignupView")
    object OnBoarding:Route("OnBoardingView")
    object HomeView:Route("HomeView")
}