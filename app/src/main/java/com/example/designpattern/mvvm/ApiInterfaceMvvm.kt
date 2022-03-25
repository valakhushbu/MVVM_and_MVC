package com.example.designpattern.mvvm

import com.example.designpattern.model.Modal
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterfaceMvvm {

    @GET("valakhushbu/bts/main/bts.json")
    suspend fun getDetails() : Response<Modal>

}