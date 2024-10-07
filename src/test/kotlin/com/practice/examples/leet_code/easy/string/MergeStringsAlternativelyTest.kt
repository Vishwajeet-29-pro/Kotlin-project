package com.practice.examples.leet_code.easy.string

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MergeStringsAlternativelyTest {

    private val mergeString = QuestionMergeStringsAlternatively()

    @Test
    fun `test merge string for two equal length string` () {
        val word1 = "abc"
        val word2 = "pqr"
        val expected = "apbqcr"
        val actual = mergeString.mergeAlternately(word1, word2)

        assertEquals(expected, actual)
    }

    @Test
    fun `test merge string for unequal strings (first word length less than second)` () {
        val word1 = "ab"
        val word2 = "pqr"
        val expected = "apbqr"
        assertEquals(expected, mergeString.mergeAlternately(word1, word2))
    }

    @Test
    fun `test merge string for unequal length (first word length is greater than second)` () {
        val word1 = "abcd"
        val word2 = "pq"
        val expected = "apbqc"
    }
}