package com.moanes.instabugtask.testingutils

import com.moanes.instabugtask.data.MainRepo
import com.moanes.instabugtask.data.Result

class MainRepoTestingImpl:MainRepo {
    override fun getWebPage(url: String): Result<String> {
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
        return Result.Success(html)
    }
}