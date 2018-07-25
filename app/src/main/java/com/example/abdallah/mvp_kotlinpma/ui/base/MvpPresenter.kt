package com.example.computec.eltadreb.ui.base

interface MvpPresenter<V : MvpView> {

    fun onAttach(mvpView: V)

    fun onDetach()


}
