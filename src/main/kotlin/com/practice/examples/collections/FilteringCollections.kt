package com.practice.examples.collections

// Filtering collection

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)

    // filter(): Filtering the collection based on condition, returning a new list with elements that meets given filter condition.
    // filter only even numbers from the list:
        // filter function is applied on collection with below syntax. 'it' is an iterator who iterates over the collection.
    val evenNumbers = numbers.filter { it % 2 == 0 }
    println(evenNumbers) // list contains 2 and 4

    // filterNot():
    // Returns a list of elements which do not match with the given condition
    val oddNumbers = numbers.filterNot { it % 2 == 0 }
    println(oddNumbers) // list contains 1, 3, 5

    // filterIndexed()
        // Allows the filtering on both the index and the value of the elements.
    val filteredWithIndex = numbers.filterIndexed { index, _ -> index % 2 == 0 }
    println(filteredWithIndex) // this will return the list of 1,3,5
}