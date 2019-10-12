package com.test.privatatms.data.respository

import com.test.privatatms.data.ApiResult
import com.test.privatatms.data.datasource.AtmDataSource
import com.test.privatatms.model.atm.Atm
import com.test.privatatms.utils.isOnline
import java.util.concurrent.TimeoutException
import javax.inject.Inject

class AtmRepository @Inject constructor(
    private val atmDataSource: AtmDataSource
) {

    fun getAtms(city: String): ApiResult<List<Atm>> {
        val cities = atmDataSource.getAtmsLocal(city)
        return if(cities.isEmpty()) {
            loadCities(city)
        }else {
            ApiResult.Success(cities)
        }
    }

    private fun loadCities(city: String): ApiResult<List<Atm>> {
        if(isOnline()) {
            return when (val apiResult = atmDataSource.getAllAtmsRemote(city)) {
                is ApiResult.Success -> {
                    val atms = apiResult.data.devices
                    atmDataSource.saveAtms(atms)
                    ApiResult.Success(atms)
                }
                is ApiResult.Error -> return ApiResult.Error(apiResult.exception)
            }
        }else {
            return ApiResult.Error(TimeoutException())
        }
    }

    fun updateAtm(atm: Atm) {
        atmDataSource.updateAtm(atm)
    }

    fun getFavoritesAtms(): List<Atm> {
        return atmDataSource.getFavotitesAtms()
    }
}