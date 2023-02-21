package com.sja.testproj.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.sja.testproj.base.BaseVBActivity
import com.sja.testproj.databinding.ActivitySharedVmoneBinding

class SharedVMActivityOne : BaseVBActivity<ActivitySharedVmoneBinding>() {

    private val sharedViewModel by lazy {
        ViewModelProvider(this).get("surprise",SharedViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel.changeTitle("ActivityOne")
        mViewBinding.button.setOnClickListener {
            jump2page(SharedVMActivityTwo::class.java)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(javaClass.simpleName, "onResume: ${sharedViewModel.getTitle()}")
    }

    override fun createViewBinding(): ActivitySharedVmoneBinding {
        return ActivitySharedVmoneBinding.inflate(layoutInflater)
    }

    override fun getViewModelStore(): ViewModelStore {
        return SharedViewModelStoreFactory.viewModelStore
    }
}