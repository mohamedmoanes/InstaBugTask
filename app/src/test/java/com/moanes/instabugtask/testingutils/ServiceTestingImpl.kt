package com.moanes.instabugtask.testingutils

import com.moanes.instabugtask.data.network.Service
import java.io.IOException

class ServiceTestingImpl : Service {
    var loadWebPageCalledFlag = false

    @Throws
    override fun loadWebPage(url: String): String {
        loadWebPageCalledFlag=true
        if (url == FakeData.failureUrl)
            throw IOException()
        return FakeData.html
    }
}