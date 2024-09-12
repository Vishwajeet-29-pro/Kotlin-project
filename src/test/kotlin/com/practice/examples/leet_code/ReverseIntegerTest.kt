package com.practice.examples.leet_code

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals

class ReverseIntegerTest {

    @Test
    fun `test reverse integer`() {
        val input = 123
        val expected = 321
        val actual = reverseInteger(input)
        assertEquals(expected, actual)
    }

    @Test
    fun `test negative integer reverse` () {
        val input = -321
        assertEquals(-123, reverseInteger(input))
    }

    @Test
    fun `assert all the edge cases` () {
        assertAll( "Edge cases", {
            assertEquals(0, reverseInteger(1234567888))
            assertEquals(0, reverseInteger(-1234567888))
        })
    }
}