package com.moanes.instabugtask.data.network

import java.net.URL

class ServiceImpl : Service {
    override fun loadWebPage(url: String): String {
        return URL(url).readText()
    }
}