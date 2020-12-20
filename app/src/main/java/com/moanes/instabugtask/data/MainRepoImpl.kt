package com.moanes.instabugtask.data

import com.moanes.instabugtask.utils.manager.SharedPreferencesManager
import java.io.IOException
import java.net.URL

class MainRepoImpl(private val sharedPreferencesManager: SharedPreferencesManager) : MainRepo {
    override fun getWebPage(url: String): Result<String> {
        return try {
            val result = URL(url).readText()
            sharedPreferencesManager.webpage = result
            Result.Success(result)
        } catch (exception: IOException) {
            Result.Failure(sharedPreferencesManager.webpage, exception)
        }
    }
}