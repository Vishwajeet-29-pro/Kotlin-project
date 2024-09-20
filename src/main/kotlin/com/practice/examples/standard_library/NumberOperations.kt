package com.practice.examples.standard_library

class NumberOperations {

    fun squareNumbers(numbers: List<Int>): List<Int> {
        return numbers.map { it * it }
    }
}

fun NumberOperations.filterEvenNumbers(numbers: List<Int>): List<Int> {
    val squareNumbers = this.squareNumbers(numbers)
    return squareNumbers.filter { it % 2 == 0 }
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6)

    val operations = NumberOperations()

    val squareNumber = operations.squareNumbers(numbers)
    println("The square of numbers from list are $squareNumber")

    val filterEvenNumber = operations.filterEvenNumbers(numbers)
    println("The even numbers are $filterEvenNumber")
}