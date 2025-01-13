package com.example.authentication.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.authentication.presentation.common_component.PrimaryButton
import com.example.authentication.presentation.navigation.Route
import com.example.authentication.presentation.viewModels.AuthViewModel
import com.example.authentication.presentation.viewModels.Authentication

@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel = viewModel(),
    navHostController: NavController
) {
    val auth = authViewModel.auth.observeAsState()
    LaunchedEffect(auth.value) {
        when (auth.value) {
            is Authentication.UnAuthenticated -> navHostController.navigate(Route.OnBoarding.route)
            else -> Unit
        }
    }
    Column(
        modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        PrimaryButton(
            modifier = Modifier.padding(horizontal = 45.dp),
            onClick = {
                authViewModel.signOut()
            },
            text = "Sign out",
        )

    }


}