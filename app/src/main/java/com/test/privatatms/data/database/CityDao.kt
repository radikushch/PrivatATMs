package com.test.privatatms.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.test.privatatms.model.city.City

@Dao
interface CityDao {

    @Query("SELECT * FROM cities")
    fun getAllCities(): List<City>

    @Insert(onConflict = REPLACE)
    fun insertCities(cities: List<City>)
}