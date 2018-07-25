package com.example.abdallah.mvp_kotlinpma.ui.popular

import com.example.abdallah.kotlinmovies.model.Movie

interface PopularMvpModel {

    interface onFinshListener {
        fun onSuccess(movies: List<Movie>)
        fun onFail(errorMsg: String)
    }

    fun loadMovies(listener: onFinshListener)

}