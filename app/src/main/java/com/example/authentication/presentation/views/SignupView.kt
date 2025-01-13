package com.example.authentication.presentation.views

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.authentication.presentation.common_component.BoxSignGoogle
import com.example.authentication.presentation.common_component.HaveAccount
import com.example.authentication.presentation.common_component.LineSignInComponent
import com.example.authentication.presentation.common_component.PrimaryButton
import com.example.authentication.presentation.common_component.TextFieldItem
import com.example.authentication.presentation.common_component.TitleAuthentication
import com.example.authentication.presentation.common_component.TitleView
import com.example.authentication.presentation.navigation.Route
import com.example.authentication.presentation.viewModels.AuthViewModel
import com.example.authentication.presentation.viewModels.Authentication

@Composable
fun SignUpView(
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = viewModel(),
    navHostController: NavController
) {
    var emailState by remember { mutableStateOf("") }
    var passwordState by remember { mutableStateOf("") }
    var fullNameState by remember { mutableStateOf("") }
    val context = LocalContext.current
    val authState by viewModel.auth.observeAsState()
    LaunchedEffect(authState) {
        when (authState) {
            is Authentication.Authenticated -> {
                Toast.makeText(context, "SignUp Successfully", Toast.LENGTH_SHORT).show()
                Log.d("Sign Up", "Sign Up: is Successfully ")
                navHostController.navigate(Route.HomeView.route) {
                    popUpTo(Route.OnBoarding.route) { inclusive = false }
                }
            }
            is Authentication.UnAuthenticated -> Log.d("Sign Up", "Sign Up: is Failure")
            is Authentication.Error -> Log.d("Sign Up", "Sign Up:${viewModel.auth.value} ")
            else -> Log.d("Sign Up", "Sign Up: is Loading ")
        }

    }

    Column(
        horizontalAlignment = Alignment.Start,

        modifier = modifier
            .fillMaxSize()
            .padding(
                horizontal = 18.dp,
                vertical = 30.dp
            )
    ) {
        TitleView("Sign Up")
        Spacer(modifier.height(10.dp))
        TitleAuthentication("Full Name")
        TextFieldItem(value = fullNameState,
            onValueChanged = {
                fullNameState = it
            })
        Spacer(modifier.height(10.dp))
        TitleAuthentication("Email")
        TextFieldItem(value = emailState,
            onValueChanged = { newValue ->
                emailState = newValue
            })
        Spacer(modifier.height(10.dp))
        TitleAuthentication("Password")
        TextFieldItem(
            value = passwordState,
            onValueChanged = { newValue ->
                passwordState = newValue
            }, isPassword = true
        )
        Spacer(modifier.height(10.dp))

        PrimaryButton(
            modifier = Modifier,
            onClick = {
                if (emailState.isNotEmpty() && passwordState.isNotEmpty()) {
                    viewModel.signUpWithEmail(email = emailState, password = passwordState)

                } else {
                    Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                }
            },
            text = "Sign Up",
        )
        HaveAccount(
            onClickListener = { navHostController.popBackStack() },
            accountState = "Already Have an account"
        )
        LineSignInComponent()
        Spacer(modifier.height(10.dp))
        BoxSignGoogle(title = "Sign Up with Google")
    }


}