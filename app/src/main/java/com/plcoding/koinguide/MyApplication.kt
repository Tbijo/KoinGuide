package com.plcoding.koinguide

import android.app.Application
import com.plcoding.koinguide.di.activityModule
import com.plcoding.koinguide.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

// MANIFEST REGISTER

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        // 2. When our app is created we want to initialize Koin

        // initialize Koin
        startKoin {

            // Login feature of Koin - optional
            androidLogger()

            // Injecting application context
            // Koin needs to know from where it can get it
            androidContext(this@MyApplication)

            // register our modules
            modules(appModule, activityModule)
        }
    }
}