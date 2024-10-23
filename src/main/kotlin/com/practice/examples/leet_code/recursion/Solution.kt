package com.practice.examples.leet_code.recursion

class Solution {
    fun fib(n: Int): Int {
        val arrayList = ArrayList<Int>()
        for(i in 0..n) {
            arrayList.add(fibo(i))
        }
        return arrayList[n]
    }

    private fun fibo(n:Int):Int {
        if(n < 2) {
            return n
        }
        return fibo(n-1) + fibo(n-2)
    }
}

fun main() {
    val sol = Solution()
    println(sol.fib(10))
}