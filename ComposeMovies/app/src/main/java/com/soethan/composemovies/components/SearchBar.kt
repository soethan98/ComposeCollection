package com.soethan.composemovies.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soethan.composemovies.ui.theme.kSearchbarColor

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(kSearchbarColor)
            .padding(20.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)){
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color.White.copy(alpha = 0.3f)
            )
            Text(
                text = "Search", fontSize = 18.sp,
                color = Color.White.copy(alpha = 0.3f)
            )
        }
    }
}