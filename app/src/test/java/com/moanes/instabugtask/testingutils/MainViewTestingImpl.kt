package com.moanes.instabugtask.testingutils

import com.moanes.instabugtask.data.model.Word
import com.moanes.instabugtask.ui.MainView

class MainViewTestingImpl : MainView {
    var setListCalledFlag = false
    var wordslist=ArrayList<Word>()
    var onFailureCalledFlag = false
    var failuerMessage :String?= null
    var showLoadingCalledFlag = false
    var hideLodaingCalledFlag = false

    override fun setList(list: List<Word>) {
        setListCalledFlag = true
        wordslist.addAll(list)
    }

    override fun onFailure(msg: String?) {
        onFailureCalledFlag = true
        failuerMessage=msg

    }

    override fun showLoading() {
        showLoadingCalledFlag = true
    }

    override fun hideLoading() {
        hideLodaingCalledFlag = true
    }
}