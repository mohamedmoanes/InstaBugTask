package com.moanes.instabugtask.utils

import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

fun String.toWordsCountMap(): Map<String, Int> {
    val wordsMap = TreeMap<String, Int>(String.CASE_INSENSITIVE_ORDER)
    val pattern = Pattern.compile("[\\s]*[a-zA-Z]+[\\s]+")
    val matcher: Matcher = pattern.matcher(this)
    while (matcher.find()) {

        var oldCount: Int? = wordsMap[matcher.group().trim()]
        if (oldCount == null) {
            oldCount = 0
        }
        wordsMap[matcher.group().trim()] = oldCount + 1

    }
    return wordsMap
}