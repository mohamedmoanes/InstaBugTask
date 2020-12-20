package com.moanes.instabugtask.data.network

interface Service {
    @Throws
    fun loadWebPage(url:String):String
}