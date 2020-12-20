package com.moanes.instabugtask.data.repositories

import com.moanes.instabugtask.data.model.Result
import com.moanes.instabugtask.data.network.Service
import com.moanes.instabugtask.utils.manager.SharedPreferencesManager
import java.io.IOException

class MainRepoImpl(private val service: Service,private val sharedPreferencesManager: SharedPreferencesManager) : MainRepo {
    override fun getWebPage(url: String): Result<String> {
        return try {
            val result = service.loadWebPage(url)
            sharedPreferencesManager.webpage = result
            Result.Success(result)
        } catch (exception: IOException) {
            Result.Failure(sharedPreferencesManager.webpage, exception)
        }
    }
}