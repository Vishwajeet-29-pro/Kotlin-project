package com.practice.examples.collections

// Set
// In kotlin, A Set is unordered collection that does not allow duplicate elements.
// There are both immutable and mutable versions of set, just like List.
// - Immutable Set: Cannot be modified after creation.
// - Mutable Set: Allows adding and removing elements.

fun main() {
    // creating Immutable set
    val fruitSet = setOf("Apple", "Banana","Cherry","Apple") // duplicate element will ignored.
    println(fruitSet) // output has only three values.

    val mutableSet = mutableSetOf(1,2,3)
    mutableSet.add(4)
    println(mutableSet)

    // Accessing elements
    // Set are unordered, so there is no indexing, we can check for membership
    println("\nChecking elements in set")
    val containsFruit = "Apple" in fruitSet
    println(containsFruit)

    // Common Set operations
    // adding elements (Mutable set)
    println("\nAdding elements to set")
    mutableSet.add(5)
    mutableSet.addAll(listOf(6,7,7,8,9)) // all elements added except duplicate 7 is ignored and adds for only one element.
    println(mutableSet)

    // removing elements (Mutable set)
    println("\nRemoving elements from set")
    mutableSet.remove(2)
    println(mutableSet)
    mutableSet.removeAll(listOf(1,3,4)) // removed all elements pass in form of collection
    println(mutableSet)

    // Iterating over set
    for (fruit in fruitSet) {
        println(fruit)
    }
}