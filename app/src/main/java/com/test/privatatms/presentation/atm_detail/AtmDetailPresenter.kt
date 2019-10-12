package com.test.privatatms.presentation.atm_detail

import com.test.privatatms.presentation.base.BasePresenter
import javax.inject.Inject

class AtmDetailPresenter @Inject constructor(
    private val atmDetailView: AtmDetailContract.AtmDetailView
): BasePresenter(), AtmDetailContract.AtmDetailPresenter {
}