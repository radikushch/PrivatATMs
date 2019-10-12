package com.test.privatatms.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.privatatms.model.atm.Atm
import com.test.privatatms.model.city.City

@Database(entities = [City::class, Atm::class], version = 2, exportSchema = false)
abstract class PrivatATMsDatabase : RoomDatabase() {

    abstract fun cityDao(): CityDao
    abstract fun atmDao(): AtmDao
}