package com.practice.examples.collections

// Sorting and Checking conditions

fun main() {
    // sorted()
    // this function sort the collection in ascending order.
    val sortedNumber = listOf(3,5,2,6,4,1).sorted()
    println(sortedNumber)

    // sortedBy()
    // sort the elements of collection based on the specified property or expression.
    println("\nsortedBy()")
    val animals = listOf("Cat", "Elephant","Dog", "Lion", "Tiger")
    val animalsSortedByLength = animals.sortedBy { it.length }
    println(animalsSortedByLength)

    // sortedDescending() and sortedByDescending
    // same as the sorted() and sortedBy() function but sorting order is descending.
    println("\nsortedDescending:")
    val animalSortedDescending = animals.sortedDescending()
    println(animalSortedDescending)

    // Checking conditions
    // all()
    // Returns true if all the element in the collection match the given predicate.
    println("\nChecking condition: all { }")
    val numbers = listOf(1, 2, 3, 4, 5)
    val allEven = numbers.all { it % 2 == 0 }
    println(allEven) // returns false, because all elements in collection does not match the predicate.

    // any()
    // returns true if at least one element in collection match with given predicate.
    println("\nAny { } ")
    val hasEven = numbers.any { it % 2 == 0 }
    println(hasEven) // returns true

    // none
    // returns true if no elements matches the predicate
    println("\nnone { } ")
    val lessThanZero = numbers.none { it < 0 }
    println(lessThanZero) // returns true as all number are greater than one.
}