package com.plcoding.koinguide.di

import com.plcoding.koinguide.presentation.MainActivity
import org.koin.core.qualifier.named
import org.koin.dsl.module

// We want dependencies to live as long as the activity they are injected into.

// EVERY MODULE MUST BE REGISTERED TO KOIN
val activityModule = module {

    // 3.
    // Scoped to MainActivity
    // provide the type of class we want to scope these to
    scope<MainActivity> {

        // This String will be scoped just to our MainActivity
        // Once the Activity is destroyed the String will be garbage collected
        scoped(qualifier = named("hello")) { "Hello" }

        // qualifier named parameter for differentiation
        scoped(qualifier = named("bye")) { "Bye" }
    }
}