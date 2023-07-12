package com.soethan.composemovies.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.soethan.composemovies.model.MovieModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun forYouMovies(modifier: Modifier = Modifier, movieList: List<MovieModel>) {

    Column(modifier = Modifier.fillMaxWidth()) {
        val pagerState = rememberPagerState()
        HorizontalPager(
            pageCount = movieList.size,
            state = pagerState,
            modifier = modifier
                .fillMaxWidth()
                .height(420.dp)
        ) {
            ForYouMovieItem(movieModel = movieList[it])
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(movieList.size) {
                val color = if (pagerState.currentPage == it) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)

                )

            }
        }


    }


}


@Composable
private fun ForYouMovieItem(movieModel: MovieModel, modifier: Modifier = Modifier) {
    val image = movieModel.image

    Image(
        painter = painterResource(id = image!!),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(20.dp)),
        contentScale = ContentScale.Crop
    )
}