package com.soethan.cleanarchformvalidation.presentation

sealed class RegistrationFormEvent {
    data class EmailChanged(val email: String) : RegistrationFormEvent()
    data class PasswordChanged(val password: String) : RegistrationFormEvent()
    data class RepeatPasswordChange(val repeatedPassword: String) : RegistrationFormEvent()
    data class AcceptTerms(val isAccepted: Boolean) : RegistrationFormEvent()
    object Submit : RegistrationFormEvent()
}