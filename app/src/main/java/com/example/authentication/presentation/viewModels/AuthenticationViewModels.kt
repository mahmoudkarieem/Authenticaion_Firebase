package com.example.authentication.presentation.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class AuthViewModel : ViewModel() {
    private val authInstance: FirebaseAuth = FirebaseAuth.getInstance()

    private val _auth = MutableLiveData<Authentication>()
    val auth: MutableLiveData<Authentication> = _auth

    init {
        checkAuthentication()
    }

    private fun checkAuthentication() {
        if (authInstance.currentUser != null) {
            _auth.value = Authentication.Authenticated
        } else {
            _auth.value = Authentication.UnAuthenticated
        }
    }

    fun loginWithEmail(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            _auth.value = Authentication.Error("Email or Password can't be empty")

        }
        viewModelScope.launch {
            try {

                _auth.value = Authentication.Loading
                authInstance
                    .signInWithEmailAndPassword(email, password)
                    .await()
                _auth.value = Authentication.Authenticated
            } catch (e: Exception) {
                _auth.value = Authentication.Error(e.message ?: "Sign In Error")
            }
        }
    }

    fun signUpWithEmail(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            _auth.value = Authentication.Error("Email or Password can't be empty")

        }
        viewModelScope.launch {
            try {
                _auth.value = Authentication.Loading
                authInstance.createUserWithEmailAndPassword(email, password)
                    .await()
                _auth.value = Authentication.Authenticated
            } catch (e: Exception) {
                _auth.value = Authentication.Error(e.message ?: "Sign Up Error")
            }

        }
    }

    fun signOut() {
        authInstance.signOut()
        _auth.value = Authentication.UnAuthenticated

    }

    fun resetAuthState() {
        if (_auth.value is Authentication.Authenticated) {
            _auth.value = Authentication.UnAuthenticated
        }
    }
}

sealed class Authentication {
    object Authenticated : Authentication()
    object UnAuthenticated : Authentication()
    object Loading : Authentication()
    data class Error(val message: String) : Authentication()
}