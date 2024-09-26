package com.practice.examples.functional_programming

fun interface NumberFilter {
    fun filter(numbers: List<Int>): List<Int>
}

val evenFilter = NumberFilter { numbers -> numbers.filter { it % 2 == 0 } }

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    val evenNumbers = evenFilter.filter(numbers)
    println(evenNumbers)  // Output: [2, 4, 6]
}
