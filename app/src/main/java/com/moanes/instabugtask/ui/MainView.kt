package com.moanes.instabugtask.ui

interface MainView {
    fun setMap(map: Map<String, Int>)
    fun onFailure(msg:String?)
    fun showLoading()
    fun hideLoading()
}