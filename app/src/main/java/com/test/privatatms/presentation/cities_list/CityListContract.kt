package com.test.privatatms.presentation.cities_list

import com.test.privatatms.model.atm.Atm
import com.test.privatatms.presentation.MvpContract
import com.test.privatatms.presentation.ViewResultState

interface CityListContract {
    interface CityListView : MvpContract.MvpView {
        fun setupCitiesList(cities: List<String>)
    }

    interface CityListPresenter : MvpContract.MvpPresenter {
        fun loadUkrainianCities()
    }
}