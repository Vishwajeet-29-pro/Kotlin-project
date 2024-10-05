package com.practice.examples.leet_code.easy.string

class QuestionArrayStringsEqual {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {

        val builder1:java.lang.StringBuilder = StringBuilder()
        val builder2 = StringBuilder()

        for (i in word1) {
            builder1.append(i)
        }

        for (i in word2) {
            builder2.append(i)
        }

        return builder1.toString() == builder2.toString();
    }
}