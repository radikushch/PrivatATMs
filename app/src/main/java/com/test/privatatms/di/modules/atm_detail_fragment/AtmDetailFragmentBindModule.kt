package com.test.privatatms.di.modules.atm_detail_fragment

import com.test.privatatms.presentation.atm_detail.AtmDetailContract
import com.test.privatatms.presentation.atm_detail.AtmDetailFragment
import dagger.Binds
import dagger.Module

@Module
abstract class AtmDetailFragmentBindModule {

    @Binds
    abstract fun bindAtmDetailView(atmDetailFragment: AtmDetailFragment): AtmDetailContract.AtmDetailView
}