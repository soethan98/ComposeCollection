package com.soethan.composemovies.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.soethan.composemovies.R
import com.soethan.composemovies.model.getDrawableResource
import com.soethan.composemovies.model.popularImages
import com.soethan.composemovies.ui.theme.ComposeMoviesTheme


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CastCardPreview() {
    ComposeMoviesTheme() {
        CastCard(cast = popularImages[0].cast!![0])

    }
}


@Composable
fun CastCard(modifier: Modifier = Modifier, cast: Map<String, String>) {
    Log.i("CastCard", "CastCard: $cast")
    Column(
        modifier = modifier
            .width(80.dp)
            .fillMaxHeight(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Image(
            painter = painterResource(id = cast["image"]!!.getDrawableResource()),
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight(0.7f)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
        )
        Text(
            text = cast["name"]!!, maxLines = 2, textAlign = TextAlign.Left,
            color = Color.White.copy(alpha = 0.7f), fontWeight = FontWeight.W400
        )
    }
}