package com.test.privatatms.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.test.privatatms.model.atm.Atm

@Dao
interface AtmDao {

    @Insert
    fun insertAtms(atms: List<Atm>)

    @Query("SELECT * FROM atms WHERE cityRU = :city")
    fun getAtms(city: String): List<Atm>

    @Query("SELECT * FROM atms WHERE isFavourite = 1")
    fun getFavoriteAtms(): List<Atm>

    @Update
    fun updateAtm(atm: Atm)
}