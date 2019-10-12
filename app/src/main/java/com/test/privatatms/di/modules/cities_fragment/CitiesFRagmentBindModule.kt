package com.test.privatatms.di.modules.cities_fragment

import com.test.privatatms.presentation.atm_list.AtmListContract
import com.test.privatatms.presentation.atm_list.AtmsFragment
import com.test.privatatms.presentation.cities_list.CitiesFragment
import com.test.privatatms.presentation.cities_list.CityListContract
import dagger.Binds
import dagger.Module

@Module
abstract class CitiesFRagmentBindModule {

    @Binds
    abstract fun bindCitiesListView(citiesFragment: CitiesFragment): CityListContract.CityListView
}