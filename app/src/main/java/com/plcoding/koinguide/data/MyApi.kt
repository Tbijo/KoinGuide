package com.plcoding.koinguide.data

import retrofit2.http.GET

interface MyApi {

    @GET("my/endpoint")
    fun callApi()
}