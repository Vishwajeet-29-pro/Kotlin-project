package com.practice.examples.collections

// Transforming collection

fun main() {
    val numbers = listOf(1,2,3,4,5)

    // map()
    // Transforming each element of list and returning new list with the result
    val squares = numbers.map { it * it }
    println(squares) // returns list of squares

    // mapIndexed()
    // Transform each element and use the index in the transformation.
    val indexMultiplied = numbers.mapIndexed { index, i -> index * i }
    println(indexMultiplied) // return list of numbers which multiplied with index i.e. [0, 2, 6, 12, 20]

    // flatMap()
    // transform each element into collection and flatten the result into single list.
    val words = listOf("Hello", "World")
    val letters = words.flatMap { it.toList() } // flatten into characters
    println(letters)

    // flatten()
    // convert the list of list into single list by concatenating all elements.
    val nestedList = listOf(listOf(1, 2), listOf(3, 4), listOf(5, 6))
    val conceitedList = nestedList.flatten()
    println(conceitedList)
}