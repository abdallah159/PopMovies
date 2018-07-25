package com.example.abdallah.kotlinmovies.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.abdallah.mvp_kotlinpma.adapter.IndecatorInterface
import kotlinx.android.synthetic.main.movie_card.view.*

open class MoviesAdapter(var movies: List<com.example.abdallah.kotlinmovies.model.Movie>, var rowLayout: Int, var context: Context, var movieListener: IndecatorInterface) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {


    open class MovieViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {


        var posterImage: ImageView = itemView!!.poster_image


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false)


        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w185/" + movies[position].poster_path)
                .into(holder.posterImage)


        holder.itemView.setOnClickListener {


            movieListener.onMovieItemClickListener(movies.get(position))

        }

    }

}