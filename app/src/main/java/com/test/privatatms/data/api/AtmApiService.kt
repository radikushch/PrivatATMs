package com.test.privatatms.data.api

import com.test.privatatms.model.atm.AtmListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AtmApiService {

    @GET("p24api/infrastructure?json&atm")
    fun getAtmList(@Query("city") city: String): Call<AtmListResponse>

}