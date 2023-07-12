package com.soethan.jetsurvery.survey.signinsignup.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.soethan.jetsurvery.R
import com.soethan.jetsurvery.survey.signinsignup.ConfirmPasswordState
import com.soethan.jetsurvery.survey.signinsignup.Email
import com.soethan.jetsurvery.survey.signinsignup.EmailState
import com.soethan.jetsurvery.survey.signinsignup.Password
import com.soethan.jetsurvery.survey.signinsignup.PasswordState
import com.soethan.jetsurvery.ui.theme.stronglyDeemphasizedAlpha


@Composable
fun SignUpContent(email: String?, onSignUpSubmitted: (email: String, password: String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        val passwordFocusRequest = remember { FocusRequester() }
        val confirmationPasswordFocusRequest = remember { FocusRequester() }


        val emailState = remember { EmailState(email) }
        Email(emailState, onImeAction = {
            passwordFocusRequest.requestFocus()
        })
        Spacer(modifier = Modifier.height(16.dp))
        val passwordState = remember {
            PasswordState()
        }
        Password(
            label = stringResource(id = R.string.password),
            passwordState = passwordState,
            imeAction = ImeAction.Next,
            onImeAction = { confirmationPasswordFocusRequest.requestFocus() },
            modifier = Modifier.focusRequester(passwordFocusRequest)
        )
        Spacer(modifier = Modifier.height(16.dp))
        val confirmPasswordState = remember { ConfirmPasswordState(passwordState = passwordState) }
        Password(
            label = stringResource(id = R.string.confirm_password),
            passwordState = confirmPasswordState,
            onImeAction = { onSignUpSubmitted(emailState.text, passwordState.text) },
            modifier = Modifier.focusRequester(confirmationPasswordFocusRequest)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.terms_and_conditions),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = stronglyDeemphasizedAlpha)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onSignUpSubmitted(emailState.text, passwordState.text) },
            modifier = Modifier.fillMaxWidth(),
            enabled = emailState.isValid &&
                    passwordState.isValid && confirmPasswordState.isValid
        ) {
            Text(text = stringResource(id = R.string.create_account))
        }
    }
}