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
}