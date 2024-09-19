package com.practice.examples.collections

fun main() {
    // creating a sequence
    // there are two ways to create a sequence
    // 1. Using sequenceOf() function:
    println("Using sequenceOf() method i.e. directly creating a sequence")
    val sequence = sequenceOf(1, 2, 3, 4, 5)
    println(sequence.toList())

    // 2. Converting a collection to sequence
    println("\nUsing asSequence() method i.e. converting collection into sequence")
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    val numberSequence = numbers.asSequence()
    println(numberSequence.toList())

    // Key difference between List and Sequence
    // Let's compare eager and lazy evaluation using example:
    // Example: Using List (Eager evaluation)
    println("\nUsing List (Eager evaluation)")
    val list = listOf(1, 2, 3, 4, 5, 6)
    val result = list
        .map { it * it }
        .filter { it % 2 == 0 }

    println(result)

    // In the above case map and filter are executed immediately, creating intermediate list after each operation

    // Example: Using Sequence (Lazy Evaluation):
    println("\nUsing Sequence (Lazy Evaluation)")
    val sequenceNumbers = sequenceOf(1, 2, 3, 4, 5, 6)
    val sequenceResult = sequenceNumbers
        .map { it * it }
        .filter { it % 2 == 0 }
        .toList() // Terminal operation to get the result
    println(sequenceResult)

    // Example of sequence processing
    println("\nSequence Processing")
    val sequenceProcessing = sequenceNumbers
        .filter {
            println("Filter: $it")
            it % 2 == 0
        }
        .map {
            println("Map: $it")
            it * it
        }
        .toList()
    println(sequenceProcessing)
}