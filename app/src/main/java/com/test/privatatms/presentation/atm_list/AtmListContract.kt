package com.test.privatatms.presentation.atm_list

import com.test.privatatms.model.Atm
import com.test.privatatms.presentation.MvpContract
import com.test.privatatms.presentation.ViewResultState

interface AtmListContract {

    interface AtmListView : MvpContract.MvpView {
        fun swapAtmList(viewResultState: ViewResultState<List<Atm>>)
    }

    interface AtmListPresenter : MvpContract.MvpPresenter {
        fun getAtmList(city: String)
        fun makeAtmFavorite(atm: Atm)
    }
}