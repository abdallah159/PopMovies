package com.example.abdallah.kotlinmovies.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class ApiClient {
    companion object {

        val BASE_URL: String = "http://api.themoviedb.org/3/"

        private var retrofit: Retrofit? = null

        fun getClient(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

            }
            return retrofit
        }


    }


}