package com.practice.examples.collections

// Map
// A Map is collection of key value pairs. Each key in map is unique, but values can be duplicated.
// Kotlin provides both Immutable and Mutable versions of Map.
// - Immutable Map: Cannot not be changed after creation
// - Mutable Map: Allows adding, removing, or modifying key-value pairs.

fun main() {
    // Immutable Map:
    val fruitMap = mapOf("Apple" to 1, "Banana" to 2, "Cherry" to 3)
    println(fruitMap)

    val mutableMap = mutableMapOf(1 to "One", 2 to "Two")
    mutableMap[3] = "Three"
    println(mutableMap)

    // Accessing the elements
    println("\nAccessing elements")
    val appleCount = fruitMap["Apple"]
    println("The fruit count for apple is $appleCount")

    // common operations
    println("\nAdding elements (Mutable Map)")
    mutableMap[4] = "Four"
    mutableMap.putAll(mapOf(5 to "Five", 6 to "Six" ))
    println(mutableMap)

    println("\nRemoving elements (Mutable Map)")
    mutableMap.remove(5)
    println(mutableMap)

    println("\nIterating over map")
    for ((key, value ) in fruitMap) {
        println("$key -> $value")
    }

    // Checking if key or value exists
    println("\nChecking key is present or not")
    val containsApple = fruitMap.containsKey("Apple")
    if (containsApple) println("Fruit Map has apple") else println("Does not contains apple")

    println("\nChecking value is present or not")
    val containsNumber = mutableMap.containsValue("Three")
    println(containsNumber)
}