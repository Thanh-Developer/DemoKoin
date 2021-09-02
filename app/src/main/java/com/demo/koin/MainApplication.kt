package com.demo.koin

import android.app.Application
import com.demo.koin.di.apiModule
import com.demo.koin.di.repositoryModule
import com.demo.koin.di.retrofitModule
import com.demo.koin.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by ThanhPQ
 */
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(listOf(repositoryModule, viewModelModule, retrofitModule, apiModule))
        }
    }
}