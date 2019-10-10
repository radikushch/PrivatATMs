package com.test.privatatms.di.app

import androidx.lifecycle.ViewModelProvider
import com.test.privatatms.di.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class AppBindModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}