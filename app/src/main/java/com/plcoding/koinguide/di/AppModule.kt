package com.plcoding.koinguide.di

import com.plcoding.koinguide.data.MainRepositoryImpl
import com.plcoding.koinguide.data.MyApi
import com.plcoding.koinguide.domain.MainRepository
import com.plcoding.koinguide.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    // 1. specify how to build dependencies

    // Singleton - single instance of a object in app lifetime
    single {
        // return an instance of the dependency we want to provide
        Retrofit.Builder()
            .baseUrl("https://google.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }

    // we require the MainRepository interface not the implementation class
    // so it is necessary to specify
    // but we provide the implementation
    single<MainRepository> {
        // get() provided by this scope
        // searches for a dependency that Koin should have it defined somewhere
        MainRepositoryImpl(get())
    }

    // factory {  } - creates a new instance every time this dependency is required
    // opposite to single {  }

    viewModel {
        MainViewModel(get(), get())
    }
}