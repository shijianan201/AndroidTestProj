package com.sja.testproj

import android.app.Application
import android.content.Context

class TestApp:Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
    }

}