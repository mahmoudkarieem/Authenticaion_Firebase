package com.example.authentication.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavController
import com.example.authentication.presentation.common_component.CircleCanvas
import com.example.authentication.presentation.common_component.PrimaryButton
import com.example.authentication.presentation.navigation.Route

@Composable
fun OnBoardingView(navHostController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {

        CircleCanvas()
        Spacer(modifier = Modifier.height(245.dp))
        Text(
            modifier = Modifier,
            text = "Welcome!",
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.secondary,
            letterSpacing = 0.09.em
        )
        Spacer(Modifier.height(10.dp))
        PrimaryButton(modifier = Modifier.padding(horizontal = 12.dp),
            colorContainerButton = MaterialTheme.colorScheme.secondary,
            colorTextContent = MaterialTheme.colorScheme.background, text = "Sign Up",
            onClick = { navHostController.navigate(Route.Signup.route) })
        Spacer(Modifier.height(10.dp))
        PrimaryButton(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = "Login",
            onClick = { navHostController.navigate(Route.Login.route) },
            colorContainerButton = MaterialTheme.colorScheme.secondary,
            colorTextContent = MaterialTheme.colorScheme.background,
        )
    }
}