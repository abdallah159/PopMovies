package com.example.abdallah.mvp_kotlinpma.ui.details


import android.view.View
import com.bumptech.glide.Glide
import com.example.abdallah.kotlinmovies.model.Movie
import com.example.abdallah.mvp_kotlinpma.R
import com.example.computec.breakfast.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_details.view.*


class DetailsFragment : BaseFragment() {


    companion object {
        var MOVIE_KEY: String = "movie"

        lateinit var mov: Movie

        fun newInstance(movie: Movie): DetailsFragment {

            mov = movie
            var detailsFragment = DetailsFragment()

            return detailsFragment


        }
    }

    override fun getFragmentView(): Int {
        return R.layout.fragment_details

    }


    override fun setUp(view: View?) {

        with(view!!) {
            movieTitle.text = mov.title
            movieDate.text = mov.release_date
            overview.text = mov.overview
            Glide.with(this).load("http://image.tmdb.org/t/p/w185/" + mov.poster_path).into(moviePoster)
        }
    }


}
