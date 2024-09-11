package com.practice.examples.collections

// List
// A List ordered collection of elements that allows duplicates. You can access elements by their index (position) in the list.
// Kotlin provides both Immutable (Lists) and Mutable (MutableLists) version
// - Immutable List: Cannot be modified (elements can't be added, removed, or replaced)
// - Mutable List: Allow modifications (you can add, remove and update elements)


fun main() {

    // Creating a List:
    // Immutable list:
    println("Immutable List: ")
    val immutableList = listOf("Apple", "Banana", "Cherry")
    println(immutableList)

    // Mutable list:
    println("\nMutable List")
    val mutableList = mutableListOf(1, 2, 3)
    mutableList.add(4)
    println(mutableList)


    // Accessing elements:
    println("\nAccessing elements")
    val firstFruit = immutableList[0]
    println("The first fruit from list '$firstFruit'")

    // common operations on list
    // Adding elements to list (mutable list)
    println("\nCommon Operations: \nAdd Element")
    mutableList.add(5)
    println(mutableList)

    // Removing the element (mutable list)
    println("\nRemove element")
    mutableList.removeAt(0)
    println(mutableList)

    // Iterating over elements
    println("\nIterating over elements")
    for (i in immutableList) {
        println(i)
    }
}
