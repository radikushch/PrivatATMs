package com.test.privatatms.di

import com.test.privatatms.presentation.AtmListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentBuilder {

    @ContributesAndroidInjector
    abstract fun contributeAtmListFragment(): AtmListFragment
}