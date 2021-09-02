package com.demo.koin.di

import com.demo.koin.remote.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 *  Create by ThanhPQ
 */
val apiModule = module {
    fun provideApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    single { provideApi(get()) }
}