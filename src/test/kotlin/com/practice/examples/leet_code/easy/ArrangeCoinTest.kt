package com.practice.examples.leet_code.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ArrangeCoinTest {
    private val arrangeCoins: QuestionArrangeCoins = QuestionArrangeCoins()

    @Test
    fun `test arrange coins`() {
        val input = 5
        val expected = 2
        val actual = arrangeCoins.arrangeCoins(input)
        assertEquals(expected, actual)
    }

    @Test
    fun `test arrange coins for input 8`() {
        assertEquals(3, arrangeCoins.arrangeCoins(8))
    }

    @Test
    fun `test integer overflow for arrange coins` () {
        val input = 1804289383
        val expected = 60070
        assertEquals(expected, arrangeCoins.arrangeCoins(input))
    }
}