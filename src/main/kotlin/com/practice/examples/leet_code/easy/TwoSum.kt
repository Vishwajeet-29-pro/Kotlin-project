package com.practice.examples.leet_code.easy

class TwoSum {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        // two pointer approach

        var start = 0
        var end = numbers.size -1

        while (start <= end) {
            val sum = numbers[start] + numbers[end]

            if (sum == target) {
                return intArrayOf(start + 1, end + 1 )
            } else if (sum < target) {
                start += 1
            } else end -= 1
        }
        return intArrayOf(-1, -1)
    }
}