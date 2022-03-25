package com.example.designpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designpattern.mvc.ApiInterface

import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.designpattern.mvc.ApiClient
import com.example.designpattern.model.Modal
import com.example.designpattern.mvvm.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    //mvvm
    lateinit var mainViewModel: MainViewModel
    lateinit var repoHelper : RepoHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //mvc
        val apiInterface = ApiClient.getInstance().create(ApiInterface::class.java)

        val call: Call<Modal> = apiInterface.getDetail()
        call.enqueue(object : Callback<Modal> {
            override fun onResponse(call: Call<Modal>, response: Response<Modal>) {
                if (response?.body() != null)
                    Log.d("response_of_mvc", "success ${response.body()!!.results}")
            }

            override fun onFailure(call: Call<Modal>, t: Throwable) {
                Log.d("response_of_mvc", "error ${t.toString()}")

            }
        })

        //mvvm with coroutines
        val apiInterfaceMvvm = RetrofitClientMvvm.getInstance().create(ApiInterfaceMvvm::class.java)
        repoHelper = RepoHelper(apiInterfaceMvvm)

        mainViewModel = ViewModelProvider(this, ViewModelFactory(repoHelper))[MainViewModel::class.java]

        mainViewModel.liveModalData.observe(this, Observer {
            Log.d("response_of_mvvm",it.toString())
        })
    }

}

