package com.plcoding.koinguide.presentation

import androidx.lifecycle.ViewModel
import com.plcoding.koinguide.domain.MainRepository

class MainViewModel(
    private val repository: MainRepository
): ViewModel() {

    fun doNetworkCall() {
        println("Something")
    }
}