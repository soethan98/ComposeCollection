package com.soethan.cleanarchformvalidation.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soethan.cleanarchformvalidation.domain.use_case.ValidateEmail
import com.soethan.cleanarchformvalidation.domain.use_case.ValidatePassword
import com.soethan.cleanarchformvalidation.domain.use_case.ValidateRepeatedPassword
import com.soethan.cleanarchformvalidation.domain.use_case.ValidateTerms
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val validateEmail: ValidateEmail = ValidateEmail(),
    private val validatePassword: ValidatePassword = ValidatePassword(),
    private val validateRepeatedPassword: ValidateRepeatedPassword = ValidateRepeatedPassword(),
    private val validateTerms: ValidateTerms = ValidateTerms()
) : ViewModel() {

    var state by mutableStateOf(RegistrationFormState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()


    fun onEvent(event: RegistrationFormEvent) {
        when (event) {
            is RegistrationFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }

            is RegistrationFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }

            is RegistrationFormEvent.RepeatPasswordChange -> {
                state = state.copy(repeatPassword = event.repeatedPassword)
            }

            is RegistrationFormEvent.AcceptTerms -> {
                state = state.copy(acceptedTerms = event.isAccepted)
            }

            is RegistrationFormEvent.Submit -> {
                submitData()
            }

        }
    }

    private fun submitData() {
        val emailResult = validateEmail.execute(state.email)
        val passwordResult = validatePassword.execute(state.password)
        val repeatedPasswordResult = validateRepeatedPassword.execute(
            state.password, state.repeatPassword
        )
        val termsResult = validateTerms.execute(state.acceptedTerms)

        val hasError =
            listOf(emailResult, passwordResult, repeatedPasswordResult, termsResult).any {
                !it.successful
            }

        if (hasError) {
            state = state.copy(
                emailError = emailResult.errorMessage, passwordError = passwordResult.errorMessage,
                repeatPasswordError = repeatedPasswordResult.errorMessage,
                termsError = termsResult.errorMessage
            )
            return
        }
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)

        }
    }


    sealed class ValidationEvent {
        object Success : ValidationEvent()
    }
}