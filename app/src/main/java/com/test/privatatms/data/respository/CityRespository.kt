package com.test.privatatms.data.respository

import com.test.privatatms.data.ApiResult
import com.test.privatatms.data.datasource.CityDataSource
import java.util.concurrent.TimeoutException
import javax.inject.Inject

class CityRespository @Inject constructor(
    private val cityDataSource: CityDataSource
) {

    fun getUkrainianCities(): ApiResult<List<String>> {
        when (val result = cityDataSource.getUkrainianCities()) {
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
                return ApiResult.Success(cities)
            }
            is ApiResult.Error -> return ApiResult.Error(result.exception)
            else -> return ApiResult.Error(TimeoutException())
        }
    }
}