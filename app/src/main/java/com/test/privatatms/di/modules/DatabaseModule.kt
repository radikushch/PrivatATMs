package com.test.privatatms.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import androidx.room.Room
import com.test.privatatms.data.database.CityDao
import com.test.privatatms.data.database.PrivatATMsDatabase

@Module
object DatabaseModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideCityDao(database: PrivatATMsDatabase): CityDao {
        return database.cityDao()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideDatabase(context: Context): PrivatATMsDatabase {
        return Room.databaseBuilder(
            context,
            PrivatATMsDatabase::class.java,
            "privat-atm-database"
        ).build()
    }
}