package com.test.privatatms.model.atm

import com.google.gson.annotations.SerializedName

data class Atm(
    @SerializedName("type")
    val type: String,
    @SerializedName("cityRU")
    val cityRU: String,
    @SerializedName("fullAddressRu")
    val fullAddressRu: String,
    @SerializedName("placeRU")
    val placeRU: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("tw")
    val tw: WorkSchedule,
    var isFavourite: Boolean = false
)

