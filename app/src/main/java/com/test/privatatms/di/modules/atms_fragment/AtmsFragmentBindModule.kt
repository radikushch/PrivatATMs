package com.test.privatatms.di.modules.atms_fragment

import com.test.privatatms.presentation.atm_list.AtmListContract
import com.test.privatatms.presentation.atm_list.AtmsFragment
import dagger.Binds
import dagger.Module

@Module
abstract class AtmsFragmentBindModule {

    @Binds
    abstract fun bindAtmListView(atmListFragment: AtmsFragment): AtmListContract.AtmListView
}