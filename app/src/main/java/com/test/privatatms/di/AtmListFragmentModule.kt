package com.test.privatatms.di

import androidx.lifecycle.ViewModel
import com.test.privatatms.di.viewmodel.ViewModelKey
import com.test.privatatms.presentation.atm_list.AtmListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AtmListFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(AtmListViewModel::class)
    abstract fun bindAtmListViewModel(atmListViewModel: AtmListViewModel): ViewModel
}