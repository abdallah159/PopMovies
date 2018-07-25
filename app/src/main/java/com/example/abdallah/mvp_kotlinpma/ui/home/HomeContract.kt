package com.example.abdallah.mvp_kotlinpma.ui.home

import com.example.abdallah.kotlinmovies.model.Movie
import com.example.computec.eltadreb.ui.base.MvpPresenter
import com.example.computec.eltadreb.ui.base.MvpView

class HomeContract {

    interface HomeMvpView : MvpView {
        fun onSuccess(movies: List<Movie>)

        fun onFailed(errorMsg: String)


    }

    interface HomeMvpPeresenter : MvpPresenter<HomeMvpView> {
        fun loadData()
    }

}