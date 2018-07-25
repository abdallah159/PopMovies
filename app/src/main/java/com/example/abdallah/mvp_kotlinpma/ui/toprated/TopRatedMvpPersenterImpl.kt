package com.example.abdallah.mvp_kotlinpma.ui.toprated

import com.example.abdallah.kotlinmovies.model.Movie

class TopRatedMvpPersenterImpl(var mView: TopRatedContract.TopRatedMvpView) : TopRatedContract.TopRatedMvpPeresenter, TopRatedMvpModel.onFinshListener {
    override fun onAttach(mvpView: TopRatedContract.TopRatedMvpView) {

    }

    override fun onDetach() {
    }


    var myModel: TopRatedMvpModelImpl = TopRatedMvpModelImpl()

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