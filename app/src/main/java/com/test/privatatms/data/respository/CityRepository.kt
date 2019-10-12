package com.test.privatatms.data.respository

import com.test.privatatms.data.ApiResult
import com.test.privatatms.data.datasource.CityDataSource
import com.test.privatatms.model.city.City
import com.test.privatatms.model.city.CityListResponse
import com.test.privatatms.utils.isOnline
import javax.inject.Inject

class CityRepository @Inject constructor(
    private val cityDataSource: CityDataSource
) {

    fun getUkrainianCities(): List<City> {
        return if(isOnline()) {
            loadCities()
        }else {
            cityDataSource.getUkrainianCitiesLocal()
        }
    }

    private fun loadCities(): List<City>{
        return when (val result = cityDataSource.getUkrainianCitiesRemote()) {
            is ApiResult.Success -> {
                val cities = parseCitiesNames(result.data)
                cityDataSource.insertCities(cities)
                cities
            }
            is ApiResult.Error -> emptyList()
        }
    }

    private fun parseCitiesNames(data: CityListResponse): ArrayList<City> {
        val citiesNames = ArrayList<String>()
        val regions = data.areas
        regions.forEach {region ->
            if(region.areas.isEmpty()) {
                citiesNames.add(region.name)
            }else {
                citiesNames.addAll(region.areas.map { it.name })
            }
        }
        val cities = ArrayList<City>()
        citiesNames.forEach { cities.add(City(name = it)) }
        return cities
    }
}