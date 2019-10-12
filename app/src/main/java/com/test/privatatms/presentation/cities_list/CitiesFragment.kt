package com.test.privatatms.presentation.cities_list

import android.os.Bundle
import android.util.Log
import android.view.View
import com.test.privatatms.R
import com.test.privatatms.presentation.base.BaseDialogFragment
import javax.inject.Inject

class CitiesFragment : BaseDialogFragment(), CityListContract.CityListView{

    @Inject
    lateinit var citiesPresenter: CitiesPresenter

    override fun setupCitiesList(cities: List<String>) {
        Log.e("cities", cities.toString())
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun layout(): Int = R.layout.fragment_cities_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        citiesPresenter.loadUkrainianCities()
    }
}