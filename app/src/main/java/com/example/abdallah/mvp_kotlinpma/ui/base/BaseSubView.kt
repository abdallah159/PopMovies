package com.example.computec.eltadreb.ui.base

import android.annotation.TargetApi
import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup

abstract class BaseSubView : ViewGroup, SubMvpView {

    private var mParentMvpView: MvpView? = null

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    @TargetApi(21)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
    }

    override fun attachParentMvpView(mvpView: MvpView) {
        mParentMvpView = mvpView
    }

    override fun showLoading() {
        mParentMvpView!!.showLoading()
    }

    override fun hideLoading() {
        mParentMvpView!!.hideLoading()
    }




    protected abstract fun bindViewsAndSetOnClickListeners()

    protected abstract fun setUp()
}
