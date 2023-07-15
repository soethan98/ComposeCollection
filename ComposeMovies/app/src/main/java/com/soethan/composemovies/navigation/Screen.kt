package com.soethan.composemovies.navigation

sealed class Screen(val route:String){
    object Home:Screen(route = "/")
    object Details:Screen(route = "/detail")

}