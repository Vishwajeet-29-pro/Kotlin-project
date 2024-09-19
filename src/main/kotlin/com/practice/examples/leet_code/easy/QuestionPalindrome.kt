package com.practice.examples.leet_code.easy

class QuestionPalindrome {
    fun isPalindrome(x: Int): Boolean {
        var x = x

        if (x < 0) return false

        var reverse = 0
        val copy = x
        while ( x > 0) {
            reverse = reverse * 10 + x % 10
            x /= 10
        }
        return reverse == copy
    }
}