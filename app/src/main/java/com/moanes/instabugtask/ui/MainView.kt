package com.moanes.instabugtask.ui

import com.moanes.instabugtask.data.Word

interface MainView {
    fun setList(list: List<Word>)
    fun onFailure(msg: String?)
    fun showLoading()
    fun hideLoading()
}