package com.practice.examples.leet_code.easy.string

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ArrayStringEqualTest {

    private val stringsEqual = QuestionArrayStringsEqual()

    @Test
    fun `test array strings are equal` () {
        val word1: Array<String> = arrayOf("a", "bc")
        val word2: Array<String> = arrayOf("ab", "c")

        assertTrue(stringsEqual.arrayStringsAreEqual(word1, word2))
    }

    @Test
    fun `test array strings are not equal` () {
        val word1: Array<String> = arrayOf("a", "bc")
        val word2: Array<String> = arrayOf("a", "cb")

        assertFalse(stringsEqual.arrayStringsAreEqual(word1, word2))
    }

    @Test
    fun `test array string are equal if second input has single word`() {
        val word1: Array<String> = arrayOf("a", "bc", "def", "g")
        val word2: Array<String> = arrayOf("abcdefg")

        assertTrue(stringsEqual.arrayStringsAreEqual(word1, word2))
    }
}