package com.practice.examples.leet_code.easy

class QuestionInsertSearchPosition {

    fun searchInsert(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1

        if (target < nums[start]) return 0

        while (start <= end) {
            val mid = start + (end - start) / 2

            if (target == nums[mid]) {
                return mid
            } else if (target > nums[mid]) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
        return start
    }
}