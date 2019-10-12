package com.test.privatatms.data.datasource

import com.test.privatatms.ApiException
import com.test.privatatms.data.ApiResult
import com.test.privatatms.data.api.AtmApiService
import com.test.privatatms.model.atm.AtmListResponse
import javax.inject.Inject

class AtmDataSource @Inject constructor(
    private val atmApiService: AtmApiService
) {

    fun getAllAtms(city: String): ApiResult<AtmListResponse> {
        val response = atmApiService.getAtmList(city).execute()
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