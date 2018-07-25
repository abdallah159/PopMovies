package com.example.abdallah.mvp_kotlinpma.ui.popular

import com.example.abdallah.kotlinmovies.model.Movie

class PopularMvpPersenterImpl(var mView: PopularContract.View) : PopularContract.PopularMvpPeresenter, PopularMvpModel.onFinshListener {
    override fun onAttach(mvpView: PopularContract.View) {

    }

    override fun onDetach() {
    }


    var myModel: PopularMvpModelImpl = PopularMvpModelImpl()

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