package com.moanes.instabugtask.utils

import com.moanes.instabugtask.data.Word
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.collections.ArrayList

fun String.toWordsCountList(): ArrayList<Word> {
    val wordsList = ArrayList<Word>()
    val pattern = Pattern.compile("[\\s]*[a-zA-Z]+[\\s]+")
    val matcher: Matcher = pattern.matcher(this)
    while (matcher.find()) {
        val word=Word(matcher.group().trim().toLowerCase(Locale.getDefault()), 1)
        if (wordsList.contains(Word(matcher.group().trim().toLowerCase(Locale.getDefault()), 1))){
            wordsList[wordsList.indexOf(word)].increaseCount()
        }else
            wordsList.add(word)
    }
    return wordsList
}