package com.eslamwaheed.fakestore.di

import com.eslamwaheed.fakestore.api.FakeStoreService
import com.eslamwaheed.fakestore.api.MainAPIOKHttpClient
import com.eslamwaheed.fakestore.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideFootballService(): FakeStoreService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(MainAPIOKHttpClient().getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FakeStoreService::class.java)
    }
}