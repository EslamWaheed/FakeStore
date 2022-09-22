package com.eslamwaheed.fakestore.api

import com.eslamwaheed.fakestore.const.ApiConst
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class MainAPIOKHttpClient {
    fun getOkHttpClient(): OkHttpClient {
        val oktHttpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(
                (ApiConst.CONNECT_TIMEOUT_MULTIPLIER * ApiConst.DEFAULT_CONNECT_TIMEOUT_IN_SEC).toLong(),
                TimeUnit.SECONDS
            )
            .writeTimeout(
                (ApiConst.CONNECT_TIMEOUT_MULTIPLIER * ApiConst.DEFAULT_WRITE_TIMEOUT_IN_SEC).toLong(),
                TimeUnit.SECONDS
            )
            .readTimeout(
                (ApiConst.CONNECT_TIMEOUT_MULTIPLIER * ApiConst.DEFAULT_READ_TIMEOUT_IN_SEC).toLong(),
                TimeUnit.SECONDS
            )
        oktHttpClientBuilder.addInterceptor { chain ->
            val builder = chain.request().newBuilder()
            chain.proceed(builder.build())
        }
        oktHttpClientBuilder.addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        return oktHttpClientBuilder.build()
    }
}