package com.test.privatatms.model

data class AtmListResponse(
    val city: String,
    val address: String,
    val devices: List<Atm>
)