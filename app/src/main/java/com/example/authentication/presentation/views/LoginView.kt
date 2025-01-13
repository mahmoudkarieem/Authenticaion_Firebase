package com.example.authentication.presentation.views

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun LoginView(
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = viewModel(),
    navHostController: NavController
) {
    val context = LocalContext.current

    var emailState by remember { mutableStateOf("") }
    var passwordState by remember { mutableStateOf("") }
    var isRemembered by remember { mutableStateOf(true) }

    val authState = viewModel.auth.observeAsState()

    LaunchedEffect(authState.value) {

        when (authState.value) {
            is Authentication.Authenticated -> {
                Toast.makeText(context, "Login Successfully", Toast.LENGTH_SHORT).show()
                navHostController.navigate(Route.HomeView.route)

            }

            is Authentication.Error -> Toast.makeText(
                context,
                (authState.value as Authentication.Error).message,
                Toast.LENGTH_SHORT
            ).show()

            else -> Unit

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
        TitleView("Login")
        Spacer(modifier.height(30.dp))
        TitleAuthentication("Email")
        TextFieldItem(value = emailState,
            onValueChanged = {
                emailState = it
            })
        Spacer(modifier.height(20.dp))
        TitleAuthentication("Password")
        TextFieldItem(
            value = passwordState,
            onValueChanged = {
                passwordState = it
            },
            isPassword = true
        )
        Spacer(modifier.height(10.dp))
        Row(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 6.dp, start = 2.dp),
        ) {
            Checkbox(
                checked = isRemembered,
                onCheckedChange = { }
            )
            Text(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .align(Alignment.CenterVertically),
                text = "Remember me?",
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(modifier.height(4.dp))

        PrimaryButton(
            modifier = Modifier,
            onClick = {
                if (emailState.isNotEmpty() && passwordState.isNotEmpty()) {
                    viewModel.loginWithEmail(email = emailState, password = passwordState)
                } else {
                    Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                }
            },
            text = "Login",
        )
        HaveAccount(
            modifier = Modifier,
            accountState = "Don't have an account!",
            onClickListener = { navHostController.navigate(Route.Signup.route) }
        )
        LineSignInComponent()
        Spacer(modifier.height(10.dp))
        BoxSignGoogle(title = "Sign in with Google")
    }


}

