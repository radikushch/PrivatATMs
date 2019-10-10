package com.test.privatatms.di

import com.test.privatatms.data.AtmRepository
import com.test.privatatms.presentation.atm_list.AtmListContract
import com.test.privatatms.presentation.atm_list.AtmListPresenterImpl
import dagger.Module
import dagger.Provides

@Module
object AtmListFragmentModule {

    @JvmStatic
    @Provides
    fun provideAtmListPresenter(
        atmListView: AtmListContract.AtmListView,
        atmRepository: AtmRepository
    ): AtmListContract.AtmListPresenter {
        return AtmListPresenterImpl(atmListView, atmRepository)
    }
}