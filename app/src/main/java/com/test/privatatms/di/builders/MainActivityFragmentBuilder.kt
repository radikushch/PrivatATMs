package com.test.privatatms.di.builders

import com.test.privatatms.di.AtmListFragmentBindModule
import com.test.privatatms.di.AtmListFragmentModule
import com.test.privatatms.presentation.atm_list.AtmListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentBuilder {

    @ContributesAndroidInjector(modules = [AtmListFragmentModule::class, AtmListFragmentBindModule::class])
    abstract fun contributeAtmListFragment(): AtmListFragment
}