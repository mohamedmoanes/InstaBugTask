package com.moanes.instabugtask.utils.manager

import android.content.Context
import android.content.SharedPreferences
import com.moanes.instabugtask.InstaBugTaskApplication

class SharedPreferencesManagerImpl : SharedPreferencesManager {
    private val sharedPreferences: SharedPreferences =
        InstaBugTaskApplication.appContext.getSharedPreferences(
            sharedPreferencesKey,
            Context.MODE_PRIVATE
        )
    private val editor = sharedPreferences.edit()

    override var webpage: String
        get()=getString(WEBPAGE)
        set(value) {
            editor.putString(WEBPAGE, value).apply()
        }

    private fun getString(key: String): String {
        sharedPreferences.getString(key, "").let { s ->
            return if (s.isNullOrBlank())
                ""
            else
                s
        }
    }


    companion object {
        private const val sharedPreferencesKey = "USERDATA"

        private const val WEBPAGE = "WEBPAGE"
    }
}