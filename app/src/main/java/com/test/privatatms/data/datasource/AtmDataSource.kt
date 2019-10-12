package com.test.privatatms.data.datasource

import com.test.privatatms.ApiException
import com.test.privatatms.data.ApiResult
import com.test.privatatms.data.api.AtmApiService
import com.test.privatatms.data.database.AtmDao
import com.test.privatatms.model.atm.Atm
import com.test.privatatms.model.atm.AtmListResponse
import com.test.privatatms.model.city.City
import javax.inject.Inject

class AtmDataSource @Inject constructor(
    private val atmApiService: AtmApiService,
    private val atmDao: AtmDao
) {

    fun getAllAtmsRemote(city: String): ApiResult<AtmListResponse> {
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

    fun getAtmsLocal(cityName: String): List<Atm> {
        return atmDao.getAtms(cityName)
    }

    fun getFavotitesAtms(): List<Atm> {
        return atmDao.getFavoriteAtms()
    }

    fun updateAtm(atm: Atm) {
        atmDao.updateAtm(atm)
    }

    fun saveAtms(atms: List<Atm>) {
        atmDao.insertAtms(atms)
    }
}