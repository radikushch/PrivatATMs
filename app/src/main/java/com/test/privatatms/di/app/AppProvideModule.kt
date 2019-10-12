package com.test.privatatms.di.app

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppProvideModule {

    @Singleton
    @JvmStatic
    @Provides
    fun provideContext(app: Application): Context = app
}