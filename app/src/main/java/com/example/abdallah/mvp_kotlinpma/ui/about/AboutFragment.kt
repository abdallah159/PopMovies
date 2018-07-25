package com.example.abdallah.mvp_kotlinpma.ui.about


import android.view.View
import android.widget.Toast
import com.example.abdallah.mvp_kotlinpma.R
import com.example.computec.breakfast.ui.base.BaseFragment


class AboutFragment : BaseFragment() {
    override fun getFragmentView(): Int {
        return R.layout.fragment_about
    }

    override fun setUp(view: View?) {
        Toast.makeText(context,"Welcome :)",Toast.LENGTH_LONG).show()
    }

    companion object {
        fun newInstance() = AboutFragment()
    }




}
