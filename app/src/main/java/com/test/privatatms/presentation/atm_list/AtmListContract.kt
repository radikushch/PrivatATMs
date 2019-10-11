package com.test.privatatms.presentation.atm_list

import androidx.lifecycle.LiveData
import com.test.privatatms.model.Atm
import com.test.privatatms.presentation.MvpContract
import com.test.privatatms.presentation.ViewResultState

interface AtmListContract {

    interface AtmListView : MvpContract.MvpView {

    }

    interface AtmListPresenter : MvpContract.MvpPresenter {
        fun getAtmList(city: String): LiveData<ViewResultState<List<Atm>>>
        fun makeAtmFavorite(atm: Atm)
    }
}