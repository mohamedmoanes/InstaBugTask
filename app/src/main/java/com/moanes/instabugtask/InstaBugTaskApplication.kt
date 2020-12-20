package com.moanes.instabugtask

import android.app.Application
import android.content.Context
import com.moanes.instabugtask.utils.manager.SharedPreferencesManager
import com.moanes.instabugtask.utils.manager.SharedPreferencesManagerImpl

class InstaBugTaskApplication : Application() {
    companion object {
        lateinit var appContext: Context
        lateinit var sharedPreferencesManager: SharedPreferencesManager
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        sharedPreferencesManager = SharedPreferencesManagerImpl()

    }
}