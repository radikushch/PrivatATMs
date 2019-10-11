package com.test.privatatms.presentation

interface MvpContract {

    interface MvpView {
        fun showLoading()
        fun hideLoading()
    }

    interface MvpPresenter {
        fun destroy()
    }
}