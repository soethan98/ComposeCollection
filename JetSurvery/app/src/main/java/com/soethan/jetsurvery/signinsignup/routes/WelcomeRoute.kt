package com.soethan.jetsurvery.survey.signinsignup.routes

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.soethan.jetsurvery.survey.signinsignup.screens.WelcomeScreen
import com.soethan.jetsurvery.survey.signinsignup.viewmodel.WelcomeViewModel
import com.soethan.jetsurvery.survey.signinsignup.viewmodel.WelcomeViewModelFactory

@Composable
fun WelcomeRoute(
    onNavigateToSignIn: (email: String) -> Unit,
    onNavigateToSignUp: (email: String) -> Unit,
    onSignInAsGuest: () -> Unit,
) {

    val welcomeViewModel: WelcomeViewModel = viewModel(factory = WelcomeViewModelFactory())

    WelcomeScreen(onSignInSignUp = {email ->
        welcomeViewModel.handleContinue(email = email,
        onNavigateToSignIn = onNavigateToSignIn,
        onNavigateToSignUp = onNavigateToSignUp)
    }, onSignInAsGuest = {
        welcomeViewModel.signInAsGuest(onSignInAsGuest)
    })
}