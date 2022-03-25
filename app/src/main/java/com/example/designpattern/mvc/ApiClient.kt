package com.example.designpattern.mvc

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    var BASE_URL = "https://raw.githubusercontent.com/"

    fun getInstance() : Retrofit{

            return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}