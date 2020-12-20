package com.moanes.instabugtask.testutils

import com.moanes.instabugtask.data.Word

object FakeWordsList {
    val wordsList = ArrayList<Word>(
        listOf(
            Word("test1", 1),
            Word("test2", 2),
            Word("test3", 3),
            Word("test4", 4)
        )
    )
}