package com.moanes.instabugtask.testingutils

import com.moanes.instabugtask.data.model.Word

object FakeData {
    val wordsList= ArrayList<Word>(
        listOf(
        Word("page", 1),
        Word("title", 1),
        Word("this", 2),
        Word("is", 2),
        Word("a", 2),
        Word("heading", 1),
        Word("paragraph", 1)
        )
    )
    val successUrl = "https://test.com/"

    val failureUrl = "https://fail.com/"

    val html = "<!DOCTYPE html>" +
            "<html>" +
            "<head>" +
            "<title>Page Title </title>" +
            "</head>" +
            "<body>" +
            "<h1>This is a Heading </h1>" +
            "<p>This is a paragraph.</p>" +
            "</body>" +
            "</html>"


}