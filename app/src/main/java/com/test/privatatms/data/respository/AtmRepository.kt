package com.test.privatatms.data.respository

import com.test.privatatms.data.ApiResult
import com.test.privatatms.data.datasource.AtmDataSource
import com.test.privatatms.model.atm.Atm
import java.util.concurrent.TimeoutException
import javax.inject.Inject

class AtmRepository @Inject constructor(
    private val atmDataSource: AtmDataSource
) {

    fun getAtms(city: String): ApiResult<List<Atm>> {
        return when (val apiResult = atmDataSource.getAllAtms(city)) {
            is ApiResult.Success -> ApiResult.Success(apiResult.data.devices)
            is ApiResult.Error -> ApiResult.Error(apiResult.exception)
        }
    }
}