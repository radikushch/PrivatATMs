package com.test.privatatms.model.city

import com.google.gson.annotations.SerializedName

data class CityListResponse(
    @SerializedName("name")
    val name: String,
    val areas: List<CityListResponse>
)