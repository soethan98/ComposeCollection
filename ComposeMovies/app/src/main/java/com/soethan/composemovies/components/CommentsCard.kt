package com.soethan.composemovies.components

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soethan.composemovies.model.MovieModel
import com.soethan.composemovies.model.getDrawableResource
import com.soethan.composemovies.model.popularImages
import com.soethan.composemovies.ui.theme.kSearchbarColor

@Composable
fun CommentsCard(modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Comments",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.W400
            )
            Text(
                text = "See all",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.W400
            )

        }
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(160.dp)
        ) {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                items(popularImages[0].comments!!.size) {
                    Box(
                        modifier = Modifier
                            .width(300.dp)
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(20.dp))
                            .background(kSearchbarColor)
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Column {
                            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Image(
                                    painter = painterResource(id = popularImages[0].comments!![it]["imageUrl"]!!.getDrawableResource()),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(50.dp)
                                        .aspectRatio(1f)
                                        .clip(CircleShape)
                                )
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        text = popularImages[0].comments!![it]["name"]!!,
                                        style = TextStyle(
                                            color = Color.White, fontWeight = FontWeight.Bold
                                        )
                                    )
                                    Text(
                                        text = popularImages[0].comments!![it]["date"]!!,
                                        style = TextStyle(
                                            color = Color.White.copy(alpha = 0.7f),
                                        )
                                    )
                                }
                                Row(
                                    modifier = Modifier,
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = popularImages[0].comments!![it]["rating"]!!,
                                        style = TextStyle(
                                            color = Color.White, fontWeight = FontWeight.Bold
                                        )
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Icon(
                                        imageVector = Icons.Filled.Star,
                                        contentDescription = null,
                                        tint = Color.Yellow,
                                        modifier = Modifier.size(12.dp)
                                    )

                                }

                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = popularImages[0].comments!![it]["comment"]!!,
                                maxLines = 3,
                                textAlign = TextAlign.Left, overflow = TextOverflow.Clip,
                                style = TextStyle(color = Color.White)
                            )

                        }

                    }
                }
            }

        }

    }
}