package com.example.designpattern.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.designpattern.model.Modal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repoHelper: RepoHelper): ViewModel() {

    init {
        viewModelScope.launch { Dispatchers.IO
            repoHelper.getDetails()
        }
    }

    val liveModalData : LiveData<Modal>
    get() = repoHelper.liveModalData

}