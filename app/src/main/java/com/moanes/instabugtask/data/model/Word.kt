package com.moanes.instabugtask.data.model

data class Word(val word: String, var count: Int) {
    fun increaseCount() {
        count++
    }

    override fun equals(other: Any?): Boolean {
        return word == (other as Word).word
    }

    override fun hashCode(): Int {
        return word.hashCode()
    }
}

