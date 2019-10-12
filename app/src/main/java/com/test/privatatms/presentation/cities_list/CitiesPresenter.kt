package com.test.privatatms.presentation.cities_list

import com.test.privatatms.data.respository.CityRepository
import com.test.privatatms.model.city.City
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
            val list = ArrayList<City>()
            cities.forEach { list.add(City(it)) }
            withContext(Dispatchers.Main) {
                cityListView.setupCitiesList(list)
            }
        }
    }
}