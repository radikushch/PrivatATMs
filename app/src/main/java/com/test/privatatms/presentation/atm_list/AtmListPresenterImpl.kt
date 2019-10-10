package com.test.privatatms.presentation.atm_list

import com.test.privatatms.presentation.base.BasePresenter
import javax.inject.Inject

class AtmListPresenterImpl @Inject constructor(
    private val atmListView: AtmListContract.AtmListView
): BasePresenter(), AtmListContract.AtmListPresenter {

}