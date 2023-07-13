package com.soethan.composemovies.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.soethan.composemovies.ui.theme.kSearchbarColor


@Composable
fun GenreTag(modifier: Modifier = Modifier, label: String) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(kSearchbarColor)
    ) {
        Text(
            text = label,
            color = Color.White.copy(alpha = 0.3f),
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp)
        )
    }
}

//@Composable
//fun ChipView(gender: String, colorResource: Color) {
//    Box(
//        modifier = Modifier
//            .wrapContentWidth()
//            .clip(RoundedCornerShape(12.dp))
//            .background(color = colorResource.copy(0.8f))
//    ) {
//        Text(
//            text = gender,
//            color = colorResource,
//            modifier = Modifier.padding(12.dp, 6.dp, 12.dp, 12.dp)
//        )
//    }
//}
