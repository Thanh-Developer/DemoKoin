package com.demo.koin.di

import com.demo.koin.repository.UserRepository
import org.koin.dsl.module

/**
 *  Create by ThanhPQ
 */
val repositoryModule = module {
    single {
        UserRepository(get())
    }
}