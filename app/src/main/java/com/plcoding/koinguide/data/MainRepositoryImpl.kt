package com.plcoding.koinguide.data

import com.plcoding.koinguide.domain.MainRepository

class MainRepositoryImpl(
    private val api: MyApi
): MainRepository {

    override fun doNetworkCall() {
        api.callApi()
    }
}