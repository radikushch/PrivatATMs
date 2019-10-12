package com.test.privatatms.di.modules.cities_fragment

import com.test.privatatms.data.respository.CityRepository
import com.test.privatatms.presentation.cities_list.CitiesPresenter
import com.test.privatatms.presentation.cities_list.CityListContract
import dagger.Module
import dagger.Provides

@Module
object CitiesFragmentProvideModule {

    @JvmStatic
    @Provides
    fun provideCitiesPresenter(
        cityListView: CityListContract.CityListView,
        cityRepository: CityRepository
    ): CityListContract.CityListPresenter {
        return CitiesPresenter(cityListView, cityRepository)
    }
}