package com.plcoding.koinguide.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.plcoding.koinguide.domain.MainRepository

class MainViewModel(
    private val repository: MainRepository,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    fun doNetworkCall() {
        println("Something")
    }
}