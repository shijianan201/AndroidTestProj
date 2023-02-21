package com.sja.testproj.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseVBActivity<VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var mViewBinding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = createViewBinding()
        setContentView(mViewBinding.root)
    }

    abstract fun createViewBinding(): VB

    fun jump2page(pageClass: Class<out AppCompatActivity>) {
        startActivity(Intent(this, pageClass))
    }

}