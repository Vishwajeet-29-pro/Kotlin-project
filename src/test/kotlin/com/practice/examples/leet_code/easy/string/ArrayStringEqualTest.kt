package com.practice.examples.leet_code.easy.string

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class ArrayStringEqualTest {

    private val stringsEqual = QuestionArrayStringsEqual()

    @Test
    fun `test array strings are equal` () {
        val word1: Array<String> = arrayOf("a", "bc")
        val word2: Array<String> = arrayOf("ab", "c")

        assertTrue(stringsEqual.arrayStringsAreEqual(word1, word2))
    }
}