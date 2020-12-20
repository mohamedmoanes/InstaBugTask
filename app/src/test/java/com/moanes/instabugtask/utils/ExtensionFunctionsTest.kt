package com.moanes.instabugtask.utils

import com.moanes.instabugtask.data.model.Word
import org.junit.Assert
import org.junit.Test

class ExtensionFunctionsTest {
    @Test
    fun `string toWordsCountMap success`() {
        val expectedList=ArrayList<Word>()
        expectedList.add(Word("test",2))
        expectedList.add(Word("a",1))
        expectedList.add(Word("for",1))
        expectedList.add(Word("the",1))
        expectedList.add(Word("method",1))
        expectedList.add(Word("success",1))
        expectedList.add(Word("lets",1))
        Assert.assertEquals(expectedList,"Test 1 a test for the method success lets test.".toWordsCountList())
    }

    @Test
    fun `string toWordsCountMap with empty string should return empty map`(){
        val expectedList=ArrayList<Word>()
        Assert.assertEquals(expectedList,"".toWordsCountList())
    }
    @Test
    fun `string toWordsCountMap with numbers only should return empty map`(){
        val expectedList=ArrayList<Word>()
        Assert.assertEquals(expectedList,"125 1 25 1 24 1 5".toWordsCountList())
    }

}