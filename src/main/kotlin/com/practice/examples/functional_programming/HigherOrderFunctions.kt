package com.practice.examples.functional_programming

fun calculator(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

fun main() {
    val addition = {x: Int, y: Int -> x + y}
    val subtraction = {x: Int, y: Int -> x - y}
    val multiplication = {x: Int, y: Int -> x * y}
    val division = {x: Int, y: Int -> x / y}

    println("Addition of numbers: ${calculator(4, 4, addition)}")
    println("Subtraction of numbers: ${calculator(4, 4, subtraction)}")
    println("Multiplication of numbers: ${calculator(4, 4, multiplication)}")
    println("Division of numbers: ${calculator(4, 4, division)}")
}