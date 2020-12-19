package com.moanes.instabugtask.ui

import androidx.core.text.HtmlCompat
import com.moanes.instabugtask.data.MainRepo
import com.moanes.instabugtask.data.Result
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class MainPresenterTest {
    @MockK
    lateinit var mainRepo: MainRepo

    @MockK
    lateinit var view: MainView

    private lateinit var executor: ExecutorService

    private lateinit var subject: MainPresenter

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        executor = Executors.newSingleThreadExecutor()
        subject = MainPresenter(mainRepo, executor, view)
    }

    @Test
    fun `getHtml success`() {
        // given
        val url = "https://test.com/"
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


        val mapResult = TreeMap<String, Int>()
        mapResult["Page"] = 1
        mapResult["Title"] = 1
        mapResult["This"] = 2
        mapResult["is"] = 2
        mapResult["a"] = 2
        mapResult["Heading"] = 1
        mapResult["paragraph"] = 1

        every { mainRepo.getWebPage(url) } returns Result.Success(html)

        mockkStatic(HtmlCompat::class)

        //when
        subject.getHtml(url)

        // then
        verify { view.showLoading() }
        verify { mainRepo.getWebPage(url) }
        verify { view.setMap(mapResult) }
        verify { view.hideLoading() }
    }

    @Test
    fun `getHtml Network Failure`() {
        // given
        val url = "https://test.com/"

        every { mainRepo.getWebPage(url) } returns Result.Failure(IOException())

        //when
        subject.getHtml(url)

        // then
        verify { view.showLoading() }
        verify { mainRepo.getWebPage(url) }
        verify { view.onFailure(IOException().localizedMessage) }
        verify { view.hideLoading() }
    }

    @Test
    fun `removeHtmlTagsAndCss success`() {
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
        val expected = "Page Title This is a Heading This is a paragraph "
        Assert.assertEquals(expected, subject.removeHtmlTagsAndCss(html))
    }

    @Test
    fun `removeHtmlTagsAndCss with empty string should return empty sting`() {
        Assert.assertEquals("", subject.removeHtmlTagsAndCss(""))
    }
}