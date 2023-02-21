package com.sja.testproj.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.sja.testproj.base.BaseVBActivity
import com.sja.testproj.databinding.ActivitySharedVmtwoBinding

class SharedVMActivityTwo : BaseVBActivity<ActivitySharedVmtwoBinding>() {
    private val sharedViewModel by lazy {
        ViewModelProvider(this).get("surprise",SharedViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        Log.d(javaClass.simpleName, "onResume: ${sharedViewModel.getTitle()}")
    }

    override fun createViewBinding(): ActivitySharedVmtwoBinding {
        return ActivitySharedVmtwoBinding.inflate(layoutInflater)
    }

    override fun getViewModelStore(): ViewModelStore {
        return SharedViewModelStoreFactory.viewModelStore
    }
}