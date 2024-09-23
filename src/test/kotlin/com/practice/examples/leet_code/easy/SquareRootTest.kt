package com.practice.examples.leet_code.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SquareRootTest {
    private val sqrt: QuestionSquareRoot = QuestionSquareRoot()

    @Test
    fun `test square root for 4 should return 2` () {
        val input = 4
        val expected = 2
        val actual = sqrt.mySqrt(input)
        assertEquals(expected, actual)
    }

    @Test
    fun `test square root for long number` () {
        val input = 2147395599
        val expected = 46339
        assertEquals(expected, sqrt.mySqrt(input))
    }

    @Test
    fun `test square root for zero should return zero` () {
        val input = 0
        val expected = 0
        assertEquals(expected, sqrt.mySqrt(input))
    }
}