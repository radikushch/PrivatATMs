package com.test.privatatms.data.api

import com.test.privatatms.data.ApiResult
import com.test.privatatms.model.city.CityListResponse
import retrofit2.Call
import retrofit2.http.GET

interface CityApiService {

    @GET("https://api.hh.ru/areas/5")
    fun getUkrainianCities(): Call<ApiResult<CityListResponse>>
}