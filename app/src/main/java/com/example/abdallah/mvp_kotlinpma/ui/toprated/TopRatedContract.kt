package com.example.abdallah.mvp_kotlinpma.ui.toprated

import com.example.abdallah.kotlinmovies.model.Movie
import com.example.computec.eltadreb.ui.base.MvpPresenter
import com.example.computec.eltadreb.ui.base.MvpView

class TopRatedContract {

    interface TopRatedMvpView :MvpView {

        fun onSuccess(movies: List<Movie>)

        fun onFailed(errorMsg: String)

    }

    interface TopRatedMvpPeresenter : MvpPresenter<TopRatedMvpView>{
        fun loadData()
    }


}