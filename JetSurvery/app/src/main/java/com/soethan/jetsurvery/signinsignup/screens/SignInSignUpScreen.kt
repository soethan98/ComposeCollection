package com.soethan.jetsurvery.survey.signinsignup.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.soethan.jetsurvery.survey.signinsignup.OrSignInAsGuest


@Composable
fun SignInSignUpScreen(
    onSignInAsGuest: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(),
    content: @Composable () -> Unit
) {
    LazyColumn(modifier = modifier, contentPadding = contentPadding) {
        item {
            Spacer(modifier = Modifier.height(44.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                content()
            }
            Spacer(modifier = Modifier.height(16.dp))
            OrSignInAsGuest(onSignInAsGuest = onSignInAsGuest)

        }
    }

}