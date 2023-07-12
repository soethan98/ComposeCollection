package com.soethan.jetsurvery.survey.signinsignup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.soethan.jetsurvery.survey.signinsignup.UserRepository

class WelcomeViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun handleContinue(
        email: String,
        onNavigateToSignUp: (email: String) -> Unit,
        onNavigateToSignIn: (email: String) -> Unit
    ) {
        if (userRepository.isKnownUserEmail(email)) {
            onNavigateToSignIn(email)
        } else {
            onNavigateToSignUp(email)
        }
    }

    fun signInAsGuest(
        onSignInComplete: () -> Unit,
    ) {
        userRepository.signInAsGuest()
        onSignInComplete()
    }
}

class WelcomeViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WelcomeViewModel::class.java)) {
            return WelcomeViewModel(UserRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
