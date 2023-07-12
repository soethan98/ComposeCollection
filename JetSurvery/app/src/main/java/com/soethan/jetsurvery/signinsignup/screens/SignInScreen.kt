package com.soethan.jetsurvery.survey.signinsignup.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.soethan.jetsurvery.R
import com.soethan.jetsurvery.survey.signinsignup.Email
import com.soethan.jetsurvery.survey.signinsignup.EmailState
import com.soethan.jetsurvery.survey.signinsignup.EmailStateSaver
import com.soethan.jetsurvery.survey.signinsignup.Password
import com.soethan.jetsurvery.survey.signinsignup.PasswordState
import com.soethan.jetsurvery.survey.signinsignup.SignInSignUpTopAppBar
import com.soethan.jetsurvery.ui.theme.JetsurveyTheme
import com.soethan.jetsurvery.util.supportWideScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class) // Scaffold is experimental in m3
@Composable
fun SignInScreen(
    email: String?,
    onSignInSubmitted: (email: String, password: String) -> Unit,
    onSignInAsGuest: () -> Unit,
    onNavUp: () -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val snackbarErrorText = stringResource(id = R.string.feature_not_available)
    val snackbarActionLabel = stringResource(id = R.string.dismiss)


    Scaffold(topBar = {
        SignInSignUpTopAppBar(
            topAppBarText = stringResource(id = R.string.sign_in),
            onNavUp = onNavUp
        )
    }, content = { contentPadding ->
        SignInSignUpScreen(
            modifier = Modifier.supportWideScreen(),
            contentPadding = contentPadding,
            onSignInAsGuest = onSignInAsGuest
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                SignInContent(
                    email = email,
                    onSignInSubmitted = onSignInSubmitted,
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextButton(onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = snackbarErrorText,
                            actionLabel = snackbarActionLabel
                        )

                    }
                }) {
                    Text(text = stringResource(id = R.string.forgot_password))
                }
            }
        }
    })
    Box(modifier = Modifier.fillMaxSize()) {
        ErrorSnackbar(snackbarHostState = snackbarHostState, onDismiss = {
            snackbarHostState.currentSnackbarData?.dismiss()
        }, modifier = Modifier.align(Alignment.BottomCenter))
    }

}


@Composable
fun SignInContent(email: String?, onSignInSubmitted: (email: String, password: String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        val focusRequester = remember {
            FocusRequester()
        }

        val emailState by rememberSaveable(stateSaver = EmailStateSaver) {
            mutableStateOf(EmailState(email))
        }
        Email(emailState = emailState, onImeAction = { focusRequester.requestFocus() })
        Spacer(modifier = Modifier.height(16.dp))
        val passwordState = remember { PasswordState() }
        val onSubmit = {
            if (emailState.isValid && passwordState.isValid) {
                onSignInSubmitted(emailState.text, passwordState.text)
            }
        }

        Password(label = stringResource(id = R.string.password), passwordState = passwordState,
            modifier = Modifier.focusRequester(focusRequester),
            onImeAction = { onSubmit() })

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onSubmit() }, modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            enabled = emailState.isValid && passwordState.isValid
        ) {
            Text(
                text = stringResource(id = R.string.sign_in)
            )
        }


    }
}


@Composable
fun ErrorSnackbar(
    snackbarHostState: SnackbarHostState, modifier: Modifier = Modifier,
    onDismiss: () -> Unit
) {
    SnackbarHost(hostState = snackbarHostState, snackbar = { data ->
        Snackbar(modifier = Modifier.padding(16.dp), content = {
            Text(
                text = data.visuals.message,
                style = MaterialTheme.typography.bodyMedium,
            )
        }, action = {
            data.visuals.actionLabel?.let {
                TextButton(onClick = onDismiss) {
                    Text(
                        text = stringResource(id = R.string.dismiss),
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                }
            }
        })

    })
}


@Preview(name = "Sign in light theme", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun SignInPreview() {
    JetsurveyTheme {
        SignInScreen(
            email = null,
            onSignInSubmitted = { _, _ -> },
            onSignInAsGuest = {},
            onNavUp = {},
        )
    }
}
