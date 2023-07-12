package com.soethan.composemovies.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.soethan.composemovies.model.MovieModel

@Composable
fun GenreItem(modifier: Modifier = Modifier, movieModel: MovieModel) {
    val image = painterResource(id = movieModel.image!!)
    Image(
        painter = image, contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .width(250.dp)
            .height(140.dp)
            .clip(RoundedCornerShape(12.dp))
    )
}