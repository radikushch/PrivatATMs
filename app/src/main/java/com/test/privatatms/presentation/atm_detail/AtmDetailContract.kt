package com.test.privatatms.presentation.atm_detail

import com.test.privatatms.model.atm.Atm
import com.test.privatatms.model.city.City
import com.test.privatatms.presentation.MvpContract
import com.test.privatatms.presentation.ViewResultState

interface AtmDetailContract {

    interface AtmDetailView : MvpContract.MvpView {
    }

    interface AtmDetailPresenter : MvpContract.MvpPresenter {
    }
}