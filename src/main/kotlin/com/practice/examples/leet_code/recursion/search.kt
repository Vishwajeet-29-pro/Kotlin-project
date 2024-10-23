package com.practice.examples.leet_code.recursion

fun search(nums: IntArray, target: Int): Int {
        return binarySearch(nums, target, 0, nums.size-1)
    }
    private fun binarySearch(arr: IntArray, target: Int, start: Int, end: Int): Int {
        if(start > end) {
            return -1
        }
        val mid = start + (end - start) /2
        if(target == arr[mid]) {
            return mid
        }
        if(target > arr[mid]) {
            return binarySearch(arr, target, mid + 1, end)
        }
        return binarySearch(arr, target, start, mid+1)
    }