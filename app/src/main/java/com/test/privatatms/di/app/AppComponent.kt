package com.test.privatatms.di.app

import android.app.Application
import com.test.privatatms.PrivatATMsApp
import com.test.privatatms.di.modules.NetworkModule
import com.test.privatatms.di.builders.ActivityBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppProvideModule::class,
    ActivityBuilder::class,
    NetworkModule::class
])
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: PrivatATMsApp)
}