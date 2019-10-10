package com.test.privatatms.presentation.atm_list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.test.privatatms.R
import com.test.privatatms.presentation.base.BaseFragment

class AtmListFragment : BaseFragment() {

    private lateinit var atmListViewModel: AtmListViewModel

    override fun layout(): Int = R.layout.fragment_atm_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        atmListViewModel = ViewModelProviders.of(this, viewModelFactory).get(AtmListViewModel::class.java)
    }
}