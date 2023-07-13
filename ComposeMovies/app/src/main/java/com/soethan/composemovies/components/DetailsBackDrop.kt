package com.soethan.composemovies.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.soethan.composemovies.model.popularImages

@Composable
fun DetailsBackDrop(modifier: Modifier = Modifier,heightInDp:Dp){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(heightInDp)
    ) {
        Image(
            painter = painterResource(id = popularImages[0].image!!),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.6f)
                        ),
                        startY = 0f,
                        endY = (heightInDp.value * 0.8f) // Adjust the value as per your requirement
                    )
                )
        )

    }
}