package com.moanes.instabugtask.data.repositories

import com.moanes.instabugtask.data.model.Result

interface MainRepo {
    fun getWebPage(url:String): Result<String>
}

