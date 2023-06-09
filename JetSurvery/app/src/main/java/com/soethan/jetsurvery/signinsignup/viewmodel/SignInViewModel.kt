package com.soethan.jetsurvery.survey.signinsignup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.soethan.jetsurvery.survey.signinsignup.UserRepository

class SignInViewModel(private val userRepository:UserRepository):ViewModel(){
    /**
     * Consider all sign ins successful
     */
    fun signIn(
        email:String,
        password:String,
        onSignInComplete: () -> Unit
    ){
        userRepository.signIn(email, password)
        onSignInComplete()
    }

    fun signInAsGuest(
        onSignInComplete: () -> Unit,
    ) {
        userRepository.signInAsGuest()
        onSignInComplete()
    }
}

class SignInViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignInViewModel::class.java)) {
            return SignInViewModel(UserRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
