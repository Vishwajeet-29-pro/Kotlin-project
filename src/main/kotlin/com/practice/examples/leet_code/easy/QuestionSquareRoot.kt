package com.practice.examples.leet_code.easy

class QuestionSquareRoot {
    fun mySqrt(x: Int): Int {
        if (x <= 0) return 0

        var start = 0
        var end = x

        while (start <= end) {
            val mid = start + (end - start) / 2
            val square: Long = mid.toLong() * mid.toLong()

            if (square == x.toLong()) {
                return mid
            } else if (square <= x.toLong()) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
        return end;
    }
}