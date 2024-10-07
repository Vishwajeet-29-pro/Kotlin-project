package com.practice.examples.leet_code.easy.string

import kotlin.math.max

class QuestionMergeStringsAlternatively {

    fun mergeAlternately(word1: String, word2: String): String {
        val builder = StringBuilder()
        val wordLength = max(word1.length, word2.length)

        for (i in 0..wordLength) {
            if (i < word1.length) builder.append(word1[i])
            if (i < word2.length) builder.append(word2[i])
        }
        return builder.toString()
    }
}