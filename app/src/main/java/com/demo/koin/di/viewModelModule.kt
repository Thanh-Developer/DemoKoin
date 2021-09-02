package com.demo.koin.di

import com.demo.koin.ui.UserViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *  Create by ThanhPQ
 */
val viewModelModule = module {
    viewModel {
        UserViewModel(get())
    }
}