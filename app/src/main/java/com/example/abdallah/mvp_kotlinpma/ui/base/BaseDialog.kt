package com.example.computec.breakfast.ui.base

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.RelativeLayout
import com.example.computec.eltadreb.ui.base.DialogMvpView
import com.rawaa.hamza.rawaa.ui.base.BaseActivity

abstract class BaseDialog : DialogFragment(), DialogMvpView {

    var baseActivity: BaseActivity? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val mActivity = context as BaseActivity?
            this.baseActivity = mActivity
            mActivity!!.onFragmentAttached()
        }
    }


    override fun showLoading() {
        baseActivity!!.showLoading()
    }

    override fun hideLoading() {
        baseActivity!!.hideLoading()
    }



    override fun isNetworkConnected(): Boolean = baseActivity!!.isNetworkConnected()


    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }


    protected abstract fun setUp(view: View?)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // the content
        val root = RelativeLayout(activity)
        root.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

        // creating the fullscreen dialog
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(root)
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window!!.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        dialog.setCanceledOnTouchOutside(false)

        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view!!, savedInstanceState)
        setUp(view)
    }

    override fun show(fragmentManager: FragmentManager, tag: String) {
        val transaction = fragmentManager.beginTransaction()
        val prevFragment = fragmentManager.findFragmentByTag(tag)
        if (prevFragment != null) {
            transaction.remove(prevFragment)
        }
        transaction.addToBackStack(null)
        show(transaction, tag)
    }

    override fun dismissDialog(tag: String) {
        dismiss()
        baseActivity!!.onFragmentDetached(tag)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}