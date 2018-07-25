package com.example.abdallah.mvp_kotlinpma.ui.home

import com.example.abdallah.kotlinmovies.model.Movie

interface HomeMvpModel {

    interface onFinshListener {
        fun onSuccess(movies: List<Movie>)
        fun onFail(errorMsg: String)
    }

    fun loadMovies(listener: onFinshListener)

}