package com.test.privatatms.di.builders

import com.test.privatatms.di.modules.atm_detail_fragment.AtmDetailFragmentBindModule
import com.test.privatatms.di.modules.atm_detail_fragment.AtmDetailFragmentProvideModule
import com.test.privatatms.di.modules.atms_fragment.AtmsFragmentBindModule
import com.test.privatatms.di.modules.atms_fragment.AtmListFragmentProvideModule
import com.test.privatatms.di.modules.cities_fragment.CitiesFRagmentBindModule
import com.test.privatatms.di.modules.cities_fragment.CitiesFragmentProvideModule
import com.test.privatatms.presentation.atm_detail.AtmDetailFragment
import com.test.privatatms.presentation.atm_list.AtmsFragment
import com.test.privatatms.presentation.cities_list.CitiesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentBuilder {

    @ContributesAndroidInjector(modules = [
        AtmListFragmentProvideModule::class,
        AtmsFragmentBindModule::class
    ])
    abstract fun contributeAtmListFragment(): AtmsFragment

    @ContributesAndroidInjector(modules = [
        CitiesFragmentProvideModule::class,
        CitiesFRagmentBindModule::class
    ])
    abstract fun contributeCityListFragment(): CitiesFragment

    @ContributesAndroidInjector(modules = [
        AtmDetailFragmentBindModule::class,
        AtmDetailFragmentProvideModule::class
    ])
    abstract fun contributeAtmDetailFragment(): AtmDetailFragment
}