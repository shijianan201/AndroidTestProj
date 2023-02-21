package com.sja.testproj.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel:ViewModel() {

    private val titleLiveData:MutableLiveData<String> = MutableLiveData()

    fun changeTitle(title:String){
        titleLiveData.value = title
    }

    fun getTitle():String? = titleLiveData.value

}