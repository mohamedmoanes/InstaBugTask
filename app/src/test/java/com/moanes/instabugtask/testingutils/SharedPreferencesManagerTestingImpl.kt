package com.moanes.instabugtask.testingutils

import com.moanes.instabugtask.utils.manager.SharedPreferencesManager

class SharedPreferencesManagerTestingImpl : SharedPreferencesManager {
    var setCalledFlag = false
    var getCalledFlag = false

    override var webpage: String
        get() {
            getCalledFlag = true
            return FakeData.html
        }
        set(value) {
            setCalledFlag = true
        }
}