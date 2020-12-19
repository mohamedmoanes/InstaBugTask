package com.moanes.instabugtask.ui

import com.moanes.instabugtask.data.MainRepo
import com.moanes.instabugtask.data.Result
import com.moanes.instabugtask.utils.toWordsCountList
import java.util.concurrent.ExecutorService

class MainPresenter(
    private val mainRepo: MainRepo,
    private val executor: ExecutorService,
    private val view: MainView
) {
    fun getHtml(url: String) {
        view.showLoading()

        val worker = Runnable {

            val result = mainRepo.getWebPage(url)
            when (result) {
                is Result.Success -> {
                    val htmlWithoutTags =
                        removeHtmlTagsAndCss(result.value)

                    view.setList(htmlWithoutTags.toWordsCountList())
                }

                is Result.Failure -> view.onFailure(result.throwable.localizedMessage)
            }

            view.hideLoading()
        }
        executor.execute(worker)
    }

    fun removeHtmlTagsAndCss(html: String): String {
        var result = html.replace("<.+?>".toRegex(), "")
        result = result.replace("\\{[^}]*\\}".toRegex(), "")
        result = result.replace(".", " ")

        return result
    }

    fun clean() =
        executor.shutdown()

}