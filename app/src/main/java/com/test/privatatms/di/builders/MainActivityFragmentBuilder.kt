package com.test.privatatms.di.builders

import com.test.privatatms.presentation.atm_list.AtmListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentBuilder {

    @ContributesAndroidInjector
    abstract fun contributeAtmListFragment(): AtmListFragment
}