package com.test.privatatms.data.datasource

import com.test.privatatms.ApiException
import com.test.privatatms.data.ApiResult
import com.test.privatatms.data.api.CityApiService
import com.test.privatatms.data.database.CityDao
import com.test.privatatms.model.city.City
import com.test.privatatms.model.city.CityListResponse
import javax.inject.Inject

class CityDataSource @Inject constructor(
    private val cityApiService: CityApiService,
    private val cityDao: CityDao
) {

    fun getUkrainianCitiesRemote(): ApiResult<CityListResponse> {
        val response = cityApiService.getUkrainianCities().execute()
        return if(response.isSuccessful && response.body() != null) {
            ApiResult.Success(response.body()!!)
        }else {
            ApiResult.Error(
                ApiException(
                    response.code(),
                    response.message()
                )
            )
        }
    }

    fun getUkrainianCitiesLocal(): List<City> {
        return cityDao.getAllCities()
    }

    fun insertCities(cities: List<City>) {
        cityDao.insertCities(cities)
    }
}