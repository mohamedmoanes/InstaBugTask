package com.moanes.instabugtask.testingutils

import com.moanes.instabugtask.data.model.Result
import com.moanes.instabugtask.data.repositories.MainRepo
import java.io.IOException

class MainRepoTestingImpl : MainRepo {
    var calledFlag = false
    override fun getWebPage(url: String): Result<String> {
        calledFlag = true
        val html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Page Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h1>This is a Heading</h1>\n" +
                "<p>This is a paragraph.</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>"

        if (url == "https://fail.com/") {
            return Result.Failure(html, IOException())

        }
        return Result.Success(html)
    }
}