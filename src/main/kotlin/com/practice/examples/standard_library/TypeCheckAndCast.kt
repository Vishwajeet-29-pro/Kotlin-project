package com.practice.examples.standard_library

fun processInput(input: Any) {
    when(input) {
        is String -> println("String of Length: ${input.length}")
        is Int -> println("Integer value: $input")
        is Double -> println("Double value: $input")
        else -> println("Unknown type")
    }
}

fun main() {
    processInput("Koltin")
    processInput(42)
    processInput(3.14)
    processInput(true)
}