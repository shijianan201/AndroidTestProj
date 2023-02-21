package com.sja.testproj.viewmodel

import androidx.lifecycle.ViewModelStore

object SharedViewModelStoreFactory {

    val viewModelStore:ViewModelStore by lazy {
        ViewModelStore()
    }

}