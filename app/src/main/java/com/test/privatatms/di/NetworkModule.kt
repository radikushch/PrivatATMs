package com.test.privatatms.di

import com.test.privatatms.data.AtmApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    private const val BASE_ENDPOINT = "https://api.privatbank.ua/"

    @Provides
    @Singleton
    @JvmStatic
    fun provideAtmSErvice(retrofit: Retrofit): AtmApiService {
        return retrofit.create(AtmApiService::class.java)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_ENDPOINT)
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