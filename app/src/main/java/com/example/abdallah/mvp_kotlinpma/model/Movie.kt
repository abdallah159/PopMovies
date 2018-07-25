package com.example.abdallah.kotlinmovies.model

import java.io.Serializable


data class Movie(var title: String, var id: Int, var overview: String, var release_date: String,var poster_path:String):Serializable