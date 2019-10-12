package com.test.privatatms.presentation.atm_detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.test.privatatms.R
import com.test.privatatms.presentation.base.BaseFragment
import javax.inject.Inject

class AtmDetailFragment : BaseFragment(), AtmDetailContract.AtmDetailView {

    @Inject lateinit var atmDetailPresenter: AtmDetailPresenter

    private val args by navArgs<AtmDetailFragmentArgs>()

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun layout(): Int = R.layout.fragment_atm_detail

    override fun destroyPresenter() {
        atmDetailPresenter.destroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.atm
    }
}