package com.soethan.composemovies.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.soethan.composemovies.ui.theme.ComposeMoviesTheme

@Composable
fun HomeAppBar(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Hi, Melanie!",
            style = MaterialTheme.typography.headlineMedium.copy(fontSize = 30.sp, color = Color.White))
        AsyncImage(
            model = "https://randomuser.me/api/portraits/men/81.jpg", contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHomeAppBar(){
    ComposeMoviesTheme {
        HomeAppBar()
    }
}