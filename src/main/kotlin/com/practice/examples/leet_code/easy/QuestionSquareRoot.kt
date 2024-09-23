package com.practice.examples.leet_code.easy

class QuestionSquareRoot {
    fun mySqrt(x: Int): Int {
        var start = 0
        var end = x

        while (start <= end) {
            val mid = start + (end - start) / 2

            if (mid.toLong() * mid.toLong() == x.toLong()) {
                return mid
            } else if (mid.toLong() * mid.toLong() <= x.toLong()) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
        return end;
    }
}