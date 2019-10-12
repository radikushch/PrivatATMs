package com.test.privatatms.data.datasource

import com.test.privatatms.ApiException
import com.test.privatatms.data.ApiResult
import com.test.privatatms.data.api.CityApiService
import com.test.privatatms.model.city.CityListResponse
import javax.inject.Inject

class CityDataSource @Inject constructor(
    private val cityApiService: CityApiService
) {

    fun getUkrainianCities(): ApiResult<CityListResponse> {
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
}