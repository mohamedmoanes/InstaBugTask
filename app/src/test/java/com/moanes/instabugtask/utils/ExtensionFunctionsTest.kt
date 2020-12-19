package com.moanes.instabugtask.utils

import org.junit.Assert
import org.junit.Test
import java.util.*

class ExtensionFunctionsTest {
    @Test
    fun `string toWordsCountMap success`() {
        val expectedMap=TreeMap<String,Int>()
        expectedMap["test"] = 2
        expectedMap["a"] = 1
        expectedMap["for"] = 1
        expectedMap["the"] = 1
        expectedMap["method"] = 1
        expectedMap["success"] = 1
        expectedMap["lets"] = 1
        Assert.assertEquals(expectedMap,"Test 1 a test for the method success lets test.".toWordsCountMap())
    }

    @Test
    fun `string toWordsCountMap with empty string should return empty map`(){
        val expectedMap=TreeMap<String,Int>()
        Assert.assertEquals(expectedMap,"".toWordsCountMap())
    }
    @Test
    fun `string toWordsCountMap with numbers only should return empty map`(){
        val expectedMap=TreeMap<String,Int>()
        Assert.assertEquals(expectedMap,"125 1 25 1 24 1 5".toWordsCountMap())
    }

}