package com.soethan.composemovies.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soethan.composemovies.R

@Composable
fun CastCrew(modifier: Modifier = Modifier,casts:List<Map<String,String>>) {
    Log.i("CastCrewHee", "CastCrew: ${casts.size} ")
    Column(verticalArrangement = Arrangement.spacedBy(16.dp), modifier = modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = R.string.cast),
            style = TextStyle(
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.W400

            )
        )
        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .height(160.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)){
            items(casts.size){
                CastCard(cast = casts[it] )
            }

        }
    }
}