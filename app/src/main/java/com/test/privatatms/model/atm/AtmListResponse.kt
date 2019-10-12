package com.test.privatatms.model.atm

import com.google.gson.annotations.SerializedName

data class AtmListResponse(
    @SerializedName("city")
    val city: String,
    @SerializedName("devices")
    val devices: List<Atm>
)