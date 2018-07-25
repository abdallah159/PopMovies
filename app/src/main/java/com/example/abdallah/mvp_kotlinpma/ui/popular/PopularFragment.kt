package com.example.abdallah.mvp_kotlinpma.ui.popular


import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.example.abdallah.kotlinmovies.adapter.MoviesAdapter
import com.example.abdallah.kotlinmovies.model.Movie
import com.example.abdallah.mvp_kotlinpma.R
import com.example.abdallah.mvp_kotlinpma.adapter.IndecatorInterface
import com.example.abdallah.mvp_kotlinpma.ui.details.DetailsFragment
import com.example.computec.breakfast.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_popular.*


class PopularFragment : BaseFragment(), PopularContract.View, IndecatorInterface {


    private lateinit var popPresenter: PopularContract.PopularMvpPeresenter

    companion object {
        fun newInstance() = PopularFragment()

    }

    override fun getFragmentView(): Int {

        return R.layout.fragment_popular
    }

    override fun setUp(view: View?) {

        popPresenter = PopularMvpPersenterImpl(this)
        showLoading()
        popPresenter.loadData()

    }


    override fun onResume() {
        super.onResume()
        popPresenter = PopularMvpPersenterImpl(this)
        popPresenter.loadData()

    }


    override fun onSuccess(movies: List<Movie>) {
        popularRecyclerView.layoutManager = GridLayoutManager(context, 2)
        popularRecyclerView.adapter = context?.let { MoviesAdapter(movies, R.layout.movie_card, it, this) }
        hideLoading()

    }

    override fun onFailed(errorMsg: String) {
        Toast.makeText(context, errorMsg, Toast.LENGTH_LONG).show()
    }

    override fun onMovieItemClickListener(movie: Movie) {
        val fragmentManger = (context as AppCompatActivity).supportFragmentManager

        fragmentManger.beginTransaction().replace(R.id.fragmContainer, DetailsFragment.newInstance(movie))
                .addToBackStack(null).commit()
    }

}
