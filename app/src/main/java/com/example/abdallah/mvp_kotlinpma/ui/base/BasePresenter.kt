package com.example.computec.eltadreb.ui.base

open class BasePresenter<V : MvpView> : MvpPresenter<V> {

    var mvpView: V? = null

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }

    override fun onDetach() {
        mvpView = null
    }

    fun isViewAttached(): Boolean = mvpView != null

    fun checkViewAttached() {
        if (!isViewAttached()) throw MvpViewNotAttachedException()
    }



    class MvpViewNotAttachedException :
            RuntimeException("Please call Presenter.onAttach(MvpView) before" + " requesting data to the Presenter")

    companion object {
        private val TAG = "BasePresenter"
    }
}
