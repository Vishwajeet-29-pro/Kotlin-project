package com.practice.examples.leet_code.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TwoSumTest {
    private val twoSum = TwoSum()

    @Test
    fun `test two sum` () {
        val input = intArrayOf(2, 7, 11, 15)
        val target = 9
        val expected = intArrayOf(1, 2)
        assertArrayEquals(expected, twoSum.twoSum(input, target))
    }

    @Test
    fun `test two sum with other array` () {
        val input = intArrayOf(2, 3, 4)
        val target = 6
        val expected = intArrayOf(1, 3)
        assertArrayEquals(expected, twoSum.twoSum(input, target))
    }
}