package com.soethan.composemovies.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soethan.composemovies.R
import com.soethan.composemovies.components.BottomBar
import com.soethan.composemovies.components.GenreItem
import com.soethan.composemovies.components.HomeAppBar
import com.soethan.composemovies.components.MovieItemCard
import com.soethan.composemovies.components.SearchBar
import com.soethan.composemovies.components.forYouMovies
import com.soethan.composemovies.model.forYouImages
import com.soethan.composemovies.model.genresList
import com.soethan.composemovies.model.legendaryImages
import com.soethan.composemovies.model.popularImages
import com.soethan.composemovies.ui.theme.kBackgroundColor

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier, content = { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(kBackgroundColor)
                .padding(paddingValues)
                .padding(horizontal = 24.dp, vertical = 16.dp)
        ) {
            LazyColumn {
                item {
                    HomeAppBar()
                    Spacer(modifier = Modifier.height(16.dp))
                    SearchBar()
                    Spacer(modifier = Modifier.height(16.dp))

                }
                item {
                    Text(
                        text = stringResource(id = R.string.for_you), style = TextStyle(
                            color = Color.White.copy(alpha = 0.7f),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W300
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    forYouMovies(movieList = forYouImages)
                    Spacer(modifier = Modifier.height(16.dp))

                }
                item {
                    Text(
                        text = stringResource(id = R.string.popular), style = TextStyle(
                            color = Color.White.copy(alpha = 0.7f),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W300
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyRow() {
                        items(popularImages.size) {
                            MovieItemCard(movieModel = popularImages[it])
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))


                }
                item {
                    Text(
                        text = stringResource(id = R.string.genres), style = TextStyle(
                            color = Color.White.copy(alpha = 0.7f),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W300
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        items(genresList.size) {
                            GenreItem(movieModel = genresList[it])
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))


                }
                item {
                    Text(
                        text = stringResource(id = R.string.legendary_movies), style = TextStyle(
                            color = Color.White.copy(alpha = 0.7f),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W300
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyRow() {
                        items(legendaryImages.size) {
                            MovieItemCard(movieModel = legendaryImages[it])
                        }
                    }

                }
            }

            BottomBar(modifier = Modifier.align(Alignment.BottomCenter))
        }
    })
}