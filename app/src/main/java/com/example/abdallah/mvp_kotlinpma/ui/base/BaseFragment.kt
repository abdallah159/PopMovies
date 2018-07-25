package com.example.computec.breakfast.ui.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.abdallah.mvp_kotlinpma.R
import com.example.computec.eltadreb.ui.base.MvpView
import com.example.computec.eltadreb.utils.CommonUtils
import com.rawaa.hamza.rawaa.ui.base.BaseActivity
import kotlinx.android.synthetic.main.progress_dialog.*

abstract class BaseFragment : Fragment(), MvpView {

    var baseActivity: BaseActivity? = null
    var fragmentView: ViewGroup? = null

    private var mProgressDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val view = inflater!!.inflate(getFragmentView(), container, false)
        val view = inflater!!.inflate(R.layout.layout_base, container, false)
        fragmentView = activity?.let { LayoutInflater.from(it).inflate(getFragmentView(), container, false) } as ViewGroup
        view!!.findViewById<ViewGroup>(R.id.layout_base_view).addView(fragmentView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(fragmentView)
    }

    protected abstract fun getFragmentView(): Int

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity?
            this.baseActivity = activity
            activity!!.onFragmentAttached()
        }
    }

    override fun showLoading() {
        hideLoading()
        progressBar.visibility = View.VISIBLE
        mProgressDialog = this.context?.let { CommonUtils.showLoadingDialog(it) }
    }

    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            progressBar.visibility = View.GONE
            mProgressDialog!!.cancel()
        }
    }


    override fun isNetworkConnected(): Boolean = baseActivity!!.isNetworkConnected()

    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }


    protected abstract fun setUp(view: View?)

    override fun onDestroy() {
        super.onDestroy()
    }

    interface Callback {

        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }
}
