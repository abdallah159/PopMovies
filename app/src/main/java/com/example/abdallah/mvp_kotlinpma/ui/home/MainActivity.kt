package com.example.abdallah.mvp_kotlinpma.ui.home

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.example.abdallah.mvp_kotlinpma.R
import com.example.abdallah.mvp_kotlinpma.ui.about.AboutFragment
import com.example.abdallah.mvp_kotlinpma.ui.popular.PopularFragment
import com.example.abdallah.mvp_kotlinpma.ui.toprated.TopRatedFragment
import com.rawaa.hamza.rawaa.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.Popular -> {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmContainer, PopularFragment.newInstance())
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.topRated -> {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmContainer, TopRatedFragment.newInstance())
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.about -> {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmContainer, AboutFragment.newInstance())
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        showLoading()
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmContainer, TopRatedFragment.newInstance())
                .addToBackStack(null)
                .commit()

        hideLoading()


    }


    override fun getActivityView(): Int {
        return R.layout.activity_main
    }

    override fun afterInflation(savedInstance: Bundle?) {
    }


}
