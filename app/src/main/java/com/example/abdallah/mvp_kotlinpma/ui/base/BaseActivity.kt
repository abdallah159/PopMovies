package com.rawaa.hamza.rawaa.ui.base


import android.annotation.TargetApi
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.abdallah.mvp_kotlinpma.R
import com.example.computec.breakfast.ui.base.BaseFragment
import com.example.computec.eltadreb.ui.base.MvpView
import com.example.computec.eltadreb.utils.NetworkUtils
import kotlinx.android.synthetic.main.layout_base.*
import kotlinx.android.synthetic.main.layout_error.*
import kotlinx.android.synthetic.main.progress_dialog.*
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

abstract class BaseActivity : AppCompatActivity(), MvpView, BaseFragment.Callback {

    private var activityView: ViewGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        activityView = LayoutInflater.from(this)
                .inflate(getActivityView(), layout_base_view, false) as ViewGroup
        layout_base_view.addView(activityView)
        afterInflation(savedInstanceState)
    }

    protected abstract fun getActivityView(): Int

    protected abstract fun afterInflation(savedInstance: Bundle?)

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean = Build.VERSION.SDK_INT < Build.VERSION_CODES.M
            || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED


    override fun showLoading() {
        errorView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        activityView!!.visibility = View.GONE
    }

    override fun hideLoading() {
        errorView.visibility = View.GONE
        progressBar.visibility = View.GONE
        activityView!!.visibility = View.VISIBLE
    }

    private fun showSnackBar(message: String) {
        val snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT)
        val sbView = snackbar.view
        val textView = sbView
                .findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
        textView.setTextColor(ContextCompat.getColor(this, R.color.whiteColor))
        snackbar.show()
    }


    override fun isNetworkConnected(): Boolean = NetworkUtils.isNetworkConnected(applicationContext)


    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }




}
