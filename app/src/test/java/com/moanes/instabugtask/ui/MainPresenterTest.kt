package com.moanes.instabugtask.ui

import com.moanes.instabugtask.testingutils.FakeData
import com.moanes.instabugtask.testingutils.MainRepoTestingImpl
import com.moanes.instabugtask.testingutils.MainViewTestingImpl
import com.moanes.instabugtask.testingutils.TestingThreadExecutor
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException
import java.util.concurrent.Executor


class MainPresenterTest {
    lateinit var mainRepo: MainRepoTestingImpl

    lateinit var view: MainViewTestingImpl

    private lateinit var executor: Executor

    private lateinit var subject: MainPresenter

    @Before
    fun setup() {
        executor = TestingThreadExecutor()
        mainRepo = MainRepoTestingImpl()
        view = MainViewTestingImpl()
        subject = MainPresenter(mainRepo, executor, view)
    }

    @Test
    fun `getHtml success`() {
        // given
        val url = FakeData.successUrl

        val wordsList = FakeData.wordsList

        //when
        subject.getHtml(url)

        // then
        Assert.assertTrue(view.showLoadingCalledFlag)
        Assert.assertTrue(mainRepo.calledFlag)
        Assert.assertTrue(view.setListCalledFlag)
        Assert.assertEquals(wordsList, view.wordslist)
        Assert.assertTrue(view.hideLodaingCalledFlag)

    }

    @Test
    fun `getHtml Network Failure`() {
        // given
        val url = FakeData.failureUrl

        val wordsList = FakeData.wordsList

        //when
        subject.getHtml(url)

        // then
        Assert.assertTrue(view.showLoadingCalledFlag)
        Assert.assertTrue(mainRepo.calledFlag)
        Assert.assertTrue(view.setListCalledFlag)
        Assert.assertEquals(wordsList, view.wordslist)
        Assert.assertTrue(view.hideLodaingCalledFlag)
        Assert.assertEquals(wordsList, view.wordslist)
        Assert.assertEquals(IOException().localizedMessage, view.failuerMessage)

    }

    @Test
    fun `removeHtmlTagsAndCss success`() {
        val html = FakeData.html
        val expected = "Page Title This is a Heading This is a paragraph "
        Assert.assertEquals(expected, subject.removeHtmlTagsAndCss(html))
    }

    @Test
    fun `removeHtmlTagsAndCss with empty string should return empty sting`() {
        Assert.assertEquals("", subject.removeHtmlTagsAndCss(""))
    }
}