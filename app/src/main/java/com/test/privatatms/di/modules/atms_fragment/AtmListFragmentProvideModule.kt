package com.test.privatatms.di.modules.atms_fragment

import com.test.privatatms.data.respository.AtmRepository
import com.test.privatatms.presentation.atm_list.AtmListContract
import com.test.privatatms.presentation.atm_list.AtmsPresenter
import dagger.Module
import dagger.Provides

@Module
object AtmListFragmentProvideModule {

    @JvmStatic
    @Provides
    fun provideAtmListPresenter(
        atmListView: AtmListContract.AtmListView,
        atmRepository: AtmRepository
    ): AtmListContract.AtmListPresenter {
        return AtmsPresenter(atmListView, atmRepository)
    }
}