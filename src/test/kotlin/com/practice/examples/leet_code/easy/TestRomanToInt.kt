package com.practice.examples.leet_code.easy

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals

class TestRomanToInt {
    private val roman = QuestionRomanToInteger()

    @Test
    fun `Test Roman To Int`() {
        val string = "III"
        val expected = 3
        assertEquals(expected, roman.romanToInt(string))
    }

    @Test
    fun `Test Roman To Int for 4, 9` () {
        assertAll("multiple inputs", {
            assertEquals(4, roman.romanToInt("IV"))
            assertEquals(9, roman.romanToInt("IX"))
            })
    }

    @Test
    fun `Test Roman to Int for LXIII` () {
        val s = "LVIII"
        val excepted = 58
        assertEquals(excepted, roman.romanToInt(s))
    }

    @Test
    fun `Test Roman to Int for big Number MCMXCIV` () {
        val s = "MCMXCIV"
        val expected = 1994
        assertEquals(expected, roman.romanToInt(s))
    }
}