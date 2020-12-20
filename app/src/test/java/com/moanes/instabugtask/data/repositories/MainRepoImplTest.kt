package com.moanes.instabugtask.data.repositories

import com.moanes.instabugtask.data.model.Result
import com.moanes.instabugtask.testingutils.FakeData
import com.moanes.instabugtask.testingutils.ServiceTestingImpl
import com.moanes.instabugtask.testingutils.SharedPreferencesManagerTestingImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException

class MainRepoImplTest {

    private lateinit var sharedPreferencesManagerTestingImpl: SharedPreferencesManagerTestingImpl

    private lateinit var serviceTestingImpl: ServiceTestingImpl

    private lateinit var subject: MainRepoImpl


    @Before
    fun setup() {
        sharedPreferencesManagerTestingImpl = SharedPreferencesManagerTestingImpl()
        serviceTestingImpl = ServiceTestingImpl()
        subject = MainRepoImpl(serviceTestingImpl, sharedPreferencesManagerTestingImpl)
    }

    @Test
    fun `getWebPage success`() {
        val url = FakeData.successUrl
        val html = FakeData.html

        subject.getWebPage(url)

        Assert.assertTrue(serviceTestingImpl.loadWebPageCalledFlag)
        Assert.assertEquals(html, serviceTestingImpl.loadWebPage(url))
        Assert.assertTrue(sharedPreferencesManagerTestingImpl.setCalledFlag)
        Assert.assertEquals(Result.Success(html), subject.getWebPage(url))
    }


    @Test(expected = Throwable::class)
    fun `getWebPage failure`() {
        val url = FakeData.failureUrl
        val html = FakeData.html

        subject.getWebPage(url)

        Assert.assertTrue(serviceTestingImpl.loadWebPageCalledFlag)
        Assert.assertEquals(IOException(), serviceTestingImpl.loadWebPage(url))
        Assert.assertTrue(sharedPreferencesManagerTestingImpl.getCalledFlag)
        Assert.assertEquals(Result.Failure(html,IOException()), subject.getWebPage(url))
    }
}