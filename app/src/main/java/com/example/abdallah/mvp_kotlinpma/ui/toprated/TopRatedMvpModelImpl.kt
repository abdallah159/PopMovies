package com.example.abdallah.mvp_kotlinpma.ui.toprated

import com.example.abdallah.kotlinmovies.model.MovieResponse
import com.example.abdallah.kotlinmovies.rest.ApiClient
import com.example.abdallah.kotlinmovies.rest.ApiInterface
import com.example.abdallah.mvp_kotlinpma.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopRatedMvpModelImpl :TopRatedMvpModel {


    override fun loadMovies(listener: TopRatedMvpModel.onFinshListener) {

        var apiInterface: ApiInterface = ApiClient.getClient()!!.create(ApiInterface::class.java)

        var call: Call<MovieResponse> = apiInterface.getTopRatedMovies(Constants.API_KEY)


        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>?, response: Response<MovieResponse>?) {
                if (response?.isSuccessful!!)
                    response.body()?.results?.let { listener.onSuccess(it) }
            }

            override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {
                listener.onFail(t?.message.toString())
            }
        })
    }
}