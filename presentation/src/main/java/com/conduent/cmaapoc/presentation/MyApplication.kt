package com.conduent.cmaapoc.presentation

import android.app.Activity
import android.app.Application

class MyApplication: Application() {

    var mActivity: Activity? = null

    override fun onCreate() {
        super.onCreate()
    }
}