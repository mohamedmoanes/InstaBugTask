package com.moanes.instabugtask.data.model

sealed class Result<T>{
    data class Success<T>(val value:T): Result<T>()
    data class Failure<T>(val value:T,val throwable: Throwable): Result<T>()
}
