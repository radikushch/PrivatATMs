package com.test.privatatms.data.respository

import com.test.privatatms.data.ApiResult
import com.test.privatatms.data.datasource.CityDataSource
import javax.inject.Inject

class CityRepository @Inject constructor(
    private val cityDataSource: CityDataSource
) {

    fun getUkrainianCities(): List<String>{
        return when (val result = cityDataSource.getUkrainianCities()) {
            is ApiResult.Success -> {
                val cities = ArrayList<String>()
                val regions = result.data.areas
                regions.forEach {region ->
                    if(region.areas.isEmpty()) {
                        cities.add(region.name)
                    }else {
                        cities.addAll(region.areas.map { it.name })
                    }
                }
                cities
            }
            is ApiResult.Error -> emptyList()
        }
    }
}