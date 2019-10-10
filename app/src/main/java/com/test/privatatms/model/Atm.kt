package com.test.privatatms.model

data class Atm(
    val cityRU: String,
    val fullAddressRu: String,
    val placeRU: String,
    val latitude: Double,
    val longitude: Double,
    val tw: WorkSchedule
)

