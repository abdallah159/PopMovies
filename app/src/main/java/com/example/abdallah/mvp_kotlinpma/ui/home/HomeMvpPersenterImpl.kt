package com.example.abdallah.mvp_kotlinpma.ui.home

import com.example.abdallah.kotlinmovies.model.Movie

class HomeMvpPersenterImpl(var mView: HomeContract.HomeMvpView) : HomeContract.HomeMvpPeresenter, HomeMvpModel.onFinshListener {
    override fun onAttach(mvpView: HomeContract.HomeMvpView) {

    }

    override fun onDetach() {
    }


    var myModel: HomeMvpModelImpl = HomeMvpModelImpl()

    override fun loadData() {
        myModel.loadMovies(this)
    }


    override fun onSuccess(movies: List<Movie>) {
        mView.onSuccess(movies)


    }

    override fun onFail(errorMsg: String) {
        mView.onFailed(errorMsg)
    }


}