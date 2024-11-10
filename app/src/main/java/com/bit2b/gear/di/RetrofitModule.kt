package com.bit2b.gear.di

import com.bit2b.gear.BuildConfig
import com.bit2b.gear.BuildConfig.BASE_URL
import com.bit2b.gear.BuildConfig.DEBUG
import com.bit2b.gear.data.remote.ApiService
import com.bit2b.gear.data.remote.MockApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val retrofitModule = module {

    single {
        retrofit(get())
    }
    single {
        MockApi().takeIf {
            BuildConfig.IS_MOCK
        }?: get<Retrofit>().create(ApiService::class.java)
    }

    single {
        providesHttplogging()
    }

    single {
        providesOkHttpClient(get())
    }
}

private fun retrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .build()

fun providesOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()
}

private fun providesHttplogging(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = if (DEBUG)
        HttpLoggingInterceptor.Level.BODY
    else
        HttpLoggingInterceptor.Level.NONE
    return interceptor
}