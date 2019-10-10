package com.test.privatatms.presentation.atm_list

import com.test.privatatms.R
import com.test.privatatms.presentation.base.BaseFragment
import javax.inject.Inject

class AtmListFragment : BaseFragment(), AtmListContract.AtmListView {

    @Inject lateinit var atmListPresenter: AtmListPresenterImpl

    override fun layout(): Int = R.layout.fragment_atm_list

}