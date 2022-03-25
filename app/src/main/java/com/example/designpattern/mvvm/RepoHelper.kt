package com.example.designpattern.mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.designpattern.model.Modal

class RepoHelper (
    private val apiInterfaceMvvm: ApiInterfaceMvvm
) {
    private val modalData = MutableLiveData<Modal>()
    val liveModalData: LiveData<Modal>
        get() = modalData

    suspend fun getDetails() {
        val result = apiInterfaceMvvm.getDetails()
        if (result.body() != null) {
            modalData.postValue(result.body())
        }else{
            Log.d("response_of_mvvm","error ${result.errorBody()}")
        }
    }

}