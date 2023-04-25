package com.yunusbedir.weatherapp.android.di

import com.yunusbedir.weatherapp.android.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    viewModel { HomeViewModel(get()) }
}