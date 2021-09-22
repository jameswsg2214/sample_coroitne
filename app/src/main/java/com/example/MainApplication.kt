package com.example

import android.app.Application
import com.judemanutd.autostarter.AutoStartPermissionHelper
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application()  {


    override fun onCreate() {
        super.onCreate()

        AutoStartPermissionHelper.getInstance().isAutoStartPermissionAvailable(applicationContext)

    }
}