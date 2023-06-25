package com.soethan.cleanarchformvalidation

import android.graphics.Paint.Align
import android.os.Bundle
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.soethan.cleanarchformvalidation.presentation.MainViewModel
import com.soethan.cleanarchformvalidation.presentation.RegistrationFormEvent
import com.soethan.cleanarchformvalidation.ui.theme.CleanArchFormValidationTheme
import kotlinx.coroutines.flow.collectLatest

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchFormValidationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel by viewModels<MainViewModel>()
                    val state = viewModel.state
                    val context = LocalContext.current
                    LaunchedEffect(key1 = context) {
                        viewModel.validationEvents.collectLatest { event ->
                            when (event) {
                                is MainViewModel.ValidationEvent.Success -> {
                                    Toast.makeText(
                                        context, "Registration successful",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }

                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(32.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        TextField(
                            value = state.email,
                            onValueChange = {
                                viewModel.onEvent(RegistrationFormEvent.EmailChanged(email = it))
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email
                            ),
                            isError = state.emailError != null,
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = {
                                Text(text = "Email")
                            },
                        )
                        if (state.emailError != null) {
                            Text(

                                text = state.emailError, color = MaterialTheme.colorScheme.error,

                                modifier = Modifier.align(Alignment.End)
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        TextField(value = state.password,
                            isError = state.passwordError != null,
                            onValueChange = {
                                viewModel.onEvent(RegistrationFormEvent.PasswordChanged(password = it))
                            },
                            modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password
                            ),
                            visualTransformation = PasswordVisualTransformation(),
                            placeholder = {
                                Text(text = "Password")
                            }
                        )
                        if (state.passwordError != null) {
                            Text(
                                text = state.passwordError,
                                color = MaterialTheme.colorScheme.error,
                                modifier = Modifier.align(Alignment.End)
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        TextField(value = state.repeatPassword,
                            isError = state.repeatPasswordError != null,
                            onValueChange = {
                                viewModel.onEvent(
                                    RegistrationFormEvent.RepeatPasswordChange(
                                        repeatedPassword = it
                                    )
                                )
                            },
                            modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password
                            ),
                            visualTransformation = PasswordVisualTransformation(),
                            placeholder = {
                                Text(text = "Repeat password")
                            }
                        )
                        if (state.repeatPasswordError != null) {
                            Text(
                                text = state.repeatPasswordError,
                                color = MaterialTheme.colorScheme.error,
                                modifier = Modifier.align(Alignment.End)
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Checkbox(checked = state.acceptedTerms,
                                onCheckedChange = {
                                    viewModel.onEvent(RegistrationFormEvent.AcceptTerms(it))
                                })
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Accept terms")
                        }
                        if (state.termsError != null) {
                            Text(text = state.termsError, color = MaterialTheme.colorScheme.error)
                        }
                        Button(onClick = {
                            viewModel.onEvent(RegistrationFormEvent.Submit)
                        }, modifier = Modifier.align(Alignment.End)) {
                            Text(text = "Submit")
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CleanArchFormValidationTheme {
        Greeting("Android")
    }
}