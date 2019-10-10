package com.test.privatatms.di

import com.test.privatatms.presentation.atm_list.AtmListContract
import com.test.privatatms.presentation.atm_list.AtmListPresenterImpl
import dagger.Module
import dagger.Provides

@Module
object AtmListFragmentModule {

    @JvmStatic
    @Provides
    fun provideAtmListPresenter(atmListView: AtmListContract.AtmListView): AtmListContract.AtmListPresenter {
        return AtmListPresenterImpl(atmListView)
    }
}