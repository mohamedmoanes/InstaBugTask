package com.moanes.instabugtask.data

import java.io.IOException
import java.net.URL

class MainRepoImpl : MainRepo {
    override fun getWebPage(url: String): Result<String> {
        return try {
            Result.Success(URL(url).readText())
        } catch (exception: IOException) {
            Result.Failure(exception)
        }
    }
}