package com.moanes.instabugtask.data

interface MainRepo {
    fun getWebPage(url:String):Result<String>
}

