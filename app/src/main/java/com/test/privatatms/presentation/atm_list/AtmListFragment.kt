package com.test.privatatms.presentation.atm_list

import android.os.Bundle
import android.view.View
import com.test.privatatms.R
import com.test.privatatms.presentation.base.BaseFragment
import javax.inject.Inject
import android.R.id
import android.graphics.Color
import android.widget.ImageView
import kotlinx.android.synthetic.main.fragment_atm_list.*


class AtmListFragment : BaseFragment(), AtmListContract.AtmListView {

    @Inject lateinit var atmListPresenter: AtmListPresenterImpl

    override fun layout(): Int = R.layout.fragment_atm_list

    override fun destroyPresenter() {
        atmListPresenter.destroy()
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        val searchIcon = atmSearchView.findViewById<ImageView>(androidx.appcompat.R.id.search_button)
        searchIcon.setColorFilter(Color.WHITE)
        val closeIcon = atmSearchView.findViewById<ImageView>(androidx.appcompat.R.id.search_close_btn)
        closeIcon.setColorFilter(Color.WHITE)
    }
}