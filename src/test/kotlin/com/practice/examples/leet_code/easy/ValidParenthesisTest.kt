package com.practice.examples.leet_code.easy

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidParenthesisTest {
    private val valid = QuestionValidParenthesis()

    @Test
    fun `test valid parenthesis method` () {
        val s = "()"
        assertTrue(valid.isValid(s))
    }

    @Test
    fun `when parenthesis are not match should return false` () {
        val s = "(}"
        assertFalse(valid.isValid(s));
    }

    @Test
    fun `test multiple inputs` () {
        assertAll("Valid parenthesis", {
            assertTrue(valid.isValid("(){}[]"))
            assertFalse(valid.isValid("(){}}{"))
        })
    }
}