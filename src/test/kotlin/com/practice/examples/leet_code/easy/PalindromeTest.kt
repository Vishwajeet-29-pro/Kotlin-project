package com.practice.examples.leet_code.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PalindromeTest {
    private val palindrome = QuestionPalindrome()

    @Test
    fun `when negative palindrome number pass should return false` () {
        assertFalse(palindrome.isPalindrome(-121))
    }

    @Test
    fun `when palindrome number pass should returns true` () {
        assertTrue(palindrome.isPalindrome(121))
    }

    @Test
    fun `when non palindrome number pass should return false` () {
        assertFalse(palindrome.isPalindrome(123))
    }

    @Test
    fun `when zero pass should return true`() {
        assertTrue(palindrome.isPalindrome(0))
    }
}