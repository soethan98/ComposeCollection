package com.soethan.cleanarchformvalidation.domain.use_case

class ValidateRepeatedPassword {
    fun execute(password:String,repeatPassword:String):ValidationResult{
        if (password!=repeatPassword){
            return ValidationResult(successful = false, errorMessage = "The password don't match")
        }
        return ValidationResult(successful = true)
    }
}