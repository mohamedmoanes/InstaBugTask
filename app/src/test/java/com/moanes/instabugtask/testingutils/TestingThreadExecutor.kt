package com.moanes.instabugtask.testingutils

import java.util.concurrent.Executor

class TestingThreadExecutor: Executor {
    override fun execute(r: Runnable) {
        r.run()
    }
}