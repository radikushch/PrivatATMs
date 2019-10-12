package com.test.privatatms.presentation.cities_list

import android.util.Log
import com.test.privatatms.R
import com.test.privatatms.presentation.base.BaseDialogFragment

class CitiesFragment : BaseDialogFragment(), CityListContract.CityListView{

    override fun setupCitiesList(cities: List<String>) {
        Log.e("cities", cities.toString())
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun layout(): Int = R.layout.fragment_cities_list

}