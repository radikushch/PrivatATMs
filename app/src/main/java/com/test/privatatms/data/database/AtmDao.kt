package com.test.privatatms.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.test.privatatms.model.atm.Atm
import com.test.privatatms.model.city.City

@Dao
interface AtmDao {

    @Insert(onConflict = IGNORE)
    fun insertAtms(atms: List<Atm>)

    @Query("SELECT * FROM atms WHERE cityRU = :city")
    fun getAtms(city: String): List<Atm>

    @Query("SELECT * FROM atms WHERE isFavourite = 1")
    fun getFavoriteAtms(): List<Atm>
}