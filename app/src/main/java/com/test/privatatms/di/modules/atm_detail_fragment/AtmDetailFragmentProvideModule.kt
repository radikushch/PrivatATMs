package com.test.privatatms.di.modules.atm_detail_fragment

import com.test.privatatms.data.respository.AtmRepository
import com.test.privatatms.presentation.atm_detail.AtmDetailContract
import com.test.privatatms.presentation.atm_detail.AtmDetailPresenter
import com.test.privatatms.presentation.atm_list.AtmListContract
import com.test.privatatms.presentation.atm_list.AtmsPresenter
import dagger.Module
import dagger.Provides

@Module
object AtmDetailFragmentProvideModule {

    @JvmStatic
    @Provides
    fun provideAtmDetailPresenter(
        atmDetailView: AtmDetailContract.AtmDetailView
    ): AtmDetailContract.AtmDetailPresenter {
        return AtmDetailPresenter(atmDetailView)
    }
}