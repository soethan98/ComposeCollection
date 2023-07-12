package com.soethan.composemovies.model

import androidx.annotation.DrawableRes
import com.soethan.composemovies.R

data class MovieModel(
    @DrawableRes val image: Int? = null,
    val movieName: String? = null,
    val movieRating: String? = null,
    val year: String? = null,
    val cast: List<Map<String, String>>? = null,
    val comments: List<Map<String, String>>? = null
)

val forYouImages = listOf<MovieModel>(
    MovieModel(image = R.drawable.for_your_image_1),
    MovieModel(image = R.drawable.for_your_image_2),
    MovieModel(image = R.drawable.for_your_image_3),
    MovieModel(image = R.drawable.for_your_image_4)
)


val popularImages = listOf<MovieModel>(
    MovieModel(
        image = R.drawable.popular_image_1,
        movieName = "Dune",
        year = "2021",
        movieRating = "8.3",
        cast = buildList {
            buildMap<String, String> {
                "name" to "Timothee Chalamet"
                "role" to "Paul Atreides"
                "image" to "actor_1.jpeg"
            }
            buildMap<String, String> {
                "name" to "Zendaya"
                "role" to "Chani"
                "image" to "actor_2.jpeg"
            }
            buildMap<String, String> {
                "name" to "Rebecca Ferguson"
                "role" to "Lady Jessica"
                "image" to "actor_3.jpeg"
            }
            buildMap<String, String> {
                "name" to "Oscar Isaac"
                "role" to "Duke Leto"
                "image" to "actor_4.jpeg"
            }
            buildMap<String, String> {
                "name" to "Jaon Momoa"
                "role" to "Duncan Idaho"
                "image" to "actor_5.jpeg"
            }


        },
        comments = listOf(
            mapOf(
                "name" to "Cody Fisher",
                "imageUrl" to "assets/actor_1.png",
                "date" to "June 14, 2022",
                "rating" to "5.0",
                "comment" to
                        "Great movie! I will review ite more than once. Special thanks to one the operator!"
            ),
            mapOf(
                "name" to "Theresa Webb",
                "imageUrl" to "assets/actor_2.png",
                "date" to "Aug 2, 2021",
                "rating" to "4.0",
                "comment" to "Not a bad movie, but not much impressed"
            ),
            mapOf(
                "name" to "Caitriona Balfe",
                "imageUrl" to "assets/actor_3.png",
                "date" to "June 26, 2020",
                "rating" to "4.8",
                "comment" to "Love the way it is designed."
            )
        )
    ),
    MovieModel(
        image = R.drawable.popular_image_2,
        movieName = "Shang-Chi",
        year = "2022",
        movieRating = "6.4"

    ),
    MovieModel(
        image = R.drawable.popular_image_3,
        movieName = "Narcos",
        year = "2020",
        movieRating = "9.7"

    ),
    MovieModel(
        image = R.drawable.for_your_image_2,
        movieName = "Shazam!",
        year = "2021",
        movieRating = "7.5"

    ),
    MovieModel(
        image = R.drawable.for_your_image_3,
        movieName = "Stranger Things",
        year = "2021",
        movieRating = "9.2"

    )
)


val legendaryImages = listOf<MovieModel>(
    MovieModel(
        image = R.drawable.legendary_movie_1,
        movieName = "Alien",
        year = "1979",
        movieRating = "7.3"
    ),
    MovieModel(
        image = R.drawable.legendary_movie_2,
        movieName = "300",
        year = "2006",
        movieRating = "9.4"
    ),
    MovieModel(
        image = R.drawable.popular_image_3,
        movieName = "Narcos",
        year = "2020",
        movieRating = "8.7"
    ),
    MovieModel(
        image = R.drawable.for_your_image_2,
        movieName = "Shazam!",
        year = "2021",
        movieRating = "7.5"
    ),
    MovieModel(
        image  = R.drawable.for_your_image_1,
        movieName = "Cruella",
        year = "2021",
        movieRating = "9.2"
    ),
);


val genresList = listOf<MovieModel>(
    MovieModel(movieName = "Horror", image = R.drawable.genres_1),
    MovieModel(movieName = "Fantasy", image = R.drawable.genres_2),
    MovieModel(movieName = "History", image = R.drawable.genres_3),
    MovieModel(movieName = "Detective", image = R.drawable.genres_4),
    MovieModel(movieName = "Action", image = R.drawable.genres_5),
);