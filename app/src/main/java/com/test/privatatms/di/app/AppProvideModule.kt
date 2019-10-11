package com.test.privatatms.di.app

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppProvideModule {

    @Singleton
    @JvmStatic
    @Provides
    fun provideContext(app: Application) = app
}