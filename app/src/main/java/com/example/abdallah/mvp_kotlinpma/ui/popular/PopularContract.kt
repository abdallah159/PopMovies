package com.example.abdallah.mvp_kotlinpma.ui.popular

import com.example.abdallah.kotlinmovies.model.Movie
import com.example.computec.eltadreb.ui.base.MvpPresenter
import com.example.computec.eltadreb.ui.base.MvpView

class PopularContract {

    interface View : MvpView{

        fun onSuccess(movies: List<Movie>)

        fun onFailed(errorMsg: String)


    }

    interface PopularMvpPeresenter : MvpPresenter<View>{
        fun loadData()
    }

}