package com.test.privatatms.data

import com.test.privatatms.model.atm.Atm
import javax.inject.Inject

class AtmRepository @Inject constructor(
    private val atmDataSource: AtmDataSource
) {

    fun getAtms(city: String): ApiResult<List<Atm>> {
        val apiResult = atmDataSource.getAllAtms(city)
        return if(apiResult is ApiResult.Success) {
            ApiResult.Success(apiResult.data.devices)
        }else {
            ApiResult.Error((apiResult as ApiResult.Error).exception)
        }
    }
}