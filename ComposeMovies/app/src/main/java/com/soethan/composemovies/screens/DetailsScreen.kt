package com.soethan.composemovies.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soethan.composemovies.R
import com.soethan.composemovies.components.CastCard
import com.soethan.composemovies.components.CastCrew
import com.soethan.composemovies.components.DetailsBackDrop
import com.soethan.composemovies.components.ExpandableText
import com.soethan.composemovies.components.GenreTag
import com.soethan.composemovies.model.MovieModel
import com.soethan.composemovies.model.popularImages
import com.soethan.composemovies.ui.theme.kBackgroundColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(modifier: Modifier = Modifier, popularMovies: List<MovieModel> = popularImages) {
    val configuration = LocalConfiguration.current
    val heightInDp = configuration.screenHeightDp.dp
    Scaffold(modifier = modifier, content = { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(kBackgroundColor)
                .padding(paddingValues = paddingValues)
        ) {

            LazyColumn() {
                item {
                    DetailsBackDrop(heightInDp = heightInDp * 0.5f)
                }
                item {
                    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = "DUNE", fontSize = 30.sp, color = Color.White,
                                fontWeight = FontWeight.W600, modifier = Modifier.weight(1f)
                            )
                            Text(
                                text = popularMovies[0].movieRating!!,
                                textAlign = TextAlign.End,
                                maxLines = 1,
                                overflow = TextOverflow.Clip,
                                style = TextStyle(
                                    color = Color.White,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Icon(
                                imageVector = Icons.Filled.Star, contentDescription = "rating",
                                tint = Color.Yellow,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "2021, Denis Villenueve",
                            style = TextStyle(
                                color = Color.White.copy(alpha = 0.4f),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.W600
                            )
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            GenreTag(label = "Epic")
                            GenreTag(label = "Fantasy")
                            GenreTag(label = "Drama")
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        ExpandableText(
                            text = stringResource(id = R.string.default_text_gen),
                            minimizedMaxLines = 3,
                            textColor = Color.White.copy(alpha = 0.7f)
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        CastCrew(casts = popularMovies[0].cast!!)
                    }
                }
            }

        }
    })


}