package com.example.abdallah.mvp_kotlinpma.ui.toprated

import com.example.abdallah.kotlinmovies.model.Movie

interface TopRatedMvpModel {

    interface onFinshListener {
        fun onSuccess(movies: List<Movie>)
        fun onFail(errorMsg: String)
    }

    fun loadMovies(listener: onFinshListener)

}