package com.practice.examples.leet_code.easy

class QuestionArrangeCoins {
    fun arrangeCoins(n: Int): Int {
        var start = 0
        var end = n

        while (start <= end) {
            val mid = start + (end - start) / 2
            val coins: Long = mid.toLong() * (mid.toLong() + 1) / 2

            when {
                coins == n.toLong() -> return mid
                coins <= n.toLong() -> start = mid + 1
                else -> end = mid - 1
            }
//            if (coins == n) {
//                return mid
//            } else if (coins <= n) {
//                start = mid + 1
//            } else end = mid - 1
        }
        return end
    }
}