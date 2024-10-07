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
}