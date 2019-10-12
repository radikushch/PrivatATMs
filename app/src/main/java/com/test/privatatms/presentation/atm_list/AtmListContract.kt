package com.test.privatatms.presentation.atm_list

import com.test.privatatms.model.atm.Atm
import com.test.privatatms.model.city.City
import com.test.privatatms.presentation.MvpContract
import com.test.privatatms.presentation.ViewResultState

interface AtmListContract {

    interface AtmListView : MvpContract.MvpView {
        fun swapAtmList(viewResultState: ViewResultState<List<Atm>>)
    }

    interface AtmListPresenter : MvpContract.MvpPresenter {
        fun loadAtmList(city: City)
        fun makeAtmFavorite(atm: Atm)
    }
}