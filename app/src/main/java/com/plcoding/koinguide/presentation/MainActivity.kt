package com.plcoding.koinguide.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.plcoding.koinguide.data.MyApi
import com.plcoding.koinguide.presentation.ui.theme.KoinGuideTheme
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.scope.activityRetainedScope
import org.koin.androidx.scope.activityScope
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

// Koin
// Opak Hilt - Not compile time injected = little bit slower

// 3. For scoped dependencies we need to inherit from AndroidScopeComponent
class MainActivity : ComponentActivity()/*, AndroidScopeComponent*/ {

    // this way of injecting ViewModel is for XML projects
//    private val viewModel by viewModel<MainViewModel>()

    // This is a regular way of injecting
    // Also a immediate injection,
    // so as soon as Activity is created
    // it will inject the MyApi and
    // it will also create the Retrofit instance
//    private val api = get<MyApi>()

    // Lazy injection - it will inject once the api2 is used
    // opposite to immediate injection
//    private val api2 by inject<MyApi>()

    // 3. variable from AndroidScopeComponent
//    override val scope: Scope by activityScope()

    // scope like viewModel
    // bye or hello dep. are saved when Activity Rotates
    // RetainedScope doesnt work with ComponentActivity just with AppCompatActivity
    //override val scope: Scope by activityRetainedScope()


    // 3. scoped string is injected
    //private val hello by inject<String>()
    // 3. Since we have more strings we need to use named("bye") to differentiate
//    private val bye by inject<String>(named("bye"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        println(bye)
        setContent {
            KoinGuideTheme {
                // 1. injecting viewModel from Koin
                val viewModel = getViewModel<MainViewModel>()
                viewModel.doNetworkCall()
            }
        }
    }
}