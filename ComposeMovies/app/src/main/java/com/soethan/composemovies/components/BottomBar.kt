package com.soethan.composemovies.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.soethan.composemovies.ui.theme.kSearchbarColor

@Composable
fun BottomBar(modifier: Modifier = Modifier) {

    Row(
        modifier = modifier
            .height(50.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(kSearchbarColor.copy(alpha = 0.6f)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,

        ) {

        Icon(
            imageVector = Icons.Default.Home,
            modifier = Modifier.size(24.dp),
            contentDescription = null,
            tint = Color.White
        )
        Icon(
            imageVector = Icons.Default.Person,
            modifier = Modifier.size(24.dp),
            contentDescription = null,
            tint = Color.White.copy(alpha = 0.5f)

        )
        Icon(
            imageVector = Icons.Default.Email,
            modifier = Modifier.size(24.dp),
            contentDescription = null,
            tint = Color.White.copy(alpha = 0.5f)

        )
        Icon(
            imageVector = Icons.Default.Menu,
            modifier = Modifier.size(24.dp),
            contentDescription = null,
            tint = Color.White.copy(alpha = 0.5f)

        )


    }


}