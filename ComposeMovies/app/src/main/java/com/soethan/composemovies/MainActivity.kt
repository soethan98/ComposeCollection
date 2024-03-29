package com.soethan.composemovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.soethan.composemovies.navigation.MovieNavHost
import com.soethan.composemovies.screens.DetailsScreen
import com.soethan.composemovies.screens.HomeScreen
import com.soethan.composemovies.ui.theme.ComposeMoviesTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMoviesTheme {
                // A surface container using the 'background' color from the theme
                MovieNavHost()
            }
        }
    }
}

