package com.test.privatatms.di

import com.test.privatatms.presentation.atm_list.AtmListContract
import com.test.privatatms.presentation.atm_list.AtmListFragment
import dagger.Binds
import dagger.Module

@Module
abstract class AtmListFragmentBindModule {

    @Binds
    abstract fun bindAtmListView(atmListFragment: AtmListFragment): AtmListContract.AtmListView
}