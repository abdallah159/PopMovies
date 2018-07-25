package com.example.abdallah.mvp_kotlinpma.ui.toprated


import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.example.abdallah.kotlinmovies.adapter.MoviesAdapter
import com.example.abdallah.kotlinmovies.model.Movie
import com.example.abdallah.mvp_kotlinpma.R
import com.example.abdallah.mvp_kotlinpma.adapter.IndecatorInterface
import com.example.abdallah.mvp_kotlinpma.ui.details.DetailsFragment
import com.example.computec.breakfast.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_top_rated.*

class TopRatedFragment : BaseFragment(), TopRatedContract.TopRatedMvpView, IndecatorInterface {


    private lateinit var myPresenter: TopRatedContract.TopRatedMvpPeresenter

    companion object {
        fun newInstance() = TopRatedFragment()
    }


    override fun getFragmentView(): Int {
        return R.layout.fragment_top_rated
    }

    override fun setUp(view: View?) {

        myPresenter = TopRatedMvpPersenterImpl(this)
        myPresenter.loadData()
        showLoading()
    }


    override fun onSuccess(movies: List<Movie>) {
        topRatedRecyclerView.layoutManager = GridLayoutManager(context, 2)
        topRatedRecyclerView.adapter = context?.let { MoviesAdapter(movies, R.layout.movie_card, it, this) }
        hideLoading()
    }

    override fun onFailed(errorMsg: String) {

    }


    override fun onMovieItemClickListener(movie: Movie) {

        val fragmentManger = (context as AppCompatActivity).supportFragmentManager

        fragmentManger.beginTransaction().replace(R.id.fragmContainer, DetailsFragment.newInstance(movie))
                .addToBackStack(null).commit()

    }


}
