package com.test.privatatms.di

import com.test.privatatms.data.api.AtmApiService
import com.test.privatatms.data.api.CityApiService
import com.test.privatatms.di.scope.AtmRetrofitClient
import com.test.privatatms.di.scope.CityRetrofitClient
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    private const val BASE_ATM_ENDPOINT = "https://api.privatbank.ua/"
    private const val BASE_CITY_ENDPOINT = "https://api.hh.ru/"

    @Provides
    @Singleton
    @JvmStatic
    fun provideAtmService(@AtmRetrofitClient retrofit: Retrofit): AtmApiService {
        return retrofit.create(AtmApiService::class.java)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideCityService(@CityRetrofitClient retrofit: Retrofit): CityApiService {
        return retrofit.create(CityApiService::class.java)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideAtmRetrofitClient(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_ATM_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }


    @CityRetrofitClient
    @Provides
    @Singleton
    @JvmStatic
    fun provideCitiesRetrofitClient(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_CITY_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }
}