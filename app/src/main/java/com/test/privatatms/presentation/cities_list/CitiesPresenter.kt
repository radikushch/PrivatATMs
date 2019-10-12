package com.test.privatatms.presentation.cities_list

import com.test.privatatms.data.respository.CityRepository
import com.test.privatatms.presentation.base.BasePresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CitiesPresenter @Inject constructor(
    private val cityListView: CityListContract.CityListView,
    private val cityRepository: CityRepository
) : BasePresenter(), CityListContract.CityListPresenter {

    override fun loadUkrainianCities() {
        launch {
            val cities = cityRepository.getUkrainianCities()
            withContext(Dispatchers.Main) {
                cityListView.setupCitiesList(cities)
            }
        }
    }
}