package com.test.privatatms.presentation.atm_list

import android.os.Bundle
import android.view.View
import com.test.privatatms.R
import com.test.privatatms.presentation.base.BaseFragment
import javax.inject.Inject
import android.R.id
import android.graphics.Color
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.test.privatatms.extensions.invisible
import com.test.privatatms.extensions.visible
import kotlinx.android.synthetic.main.fragment_atm_list.*


class AtmListFragment : BaseFragment(), AtmListContract.AtmListView {

    @Inject lateinit var atmListPresenter: AtmListPresenterImpl

    override fun layout(): Int = R.layout.fragment_atm_list

    override fun destroyPresenter() {
        atmListPresenter.destroy()
    }

    override fun showLoading() {
        loadingProgressBar.visible()
    }

    override fun hideLoading() {
        loadingProgressBar.invisible()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        showLoading()
        atmListPresenter.getAtmList("Киев").observe(this , Observer {
            if(it.isSuccess) {
                Log.e("atms", it.data.toString())
            }else {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun setupViews() {
        val searchIcon = atmSearchView.findViewById<ImageView>(androidx.appcompat.R.id.search_button)
        searchIcon.setColorFilter(Color.WHITE)
        val closeIcon = atmSearchView.findViewById<ImageView>(androidx.appcompat.R.id.search_close_btn)
        closeIcon.setColorFilter(Color.WHITE)
    }
}