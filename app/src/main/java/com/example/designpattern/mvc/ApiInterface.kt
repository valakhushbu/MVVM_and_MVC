package com.example.designpattern.mvc

import com.example.designpattern.model.Modal
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("valakhushbu/bts/main/bts.json")
    fun getDetail(): Call<Modal>
}
