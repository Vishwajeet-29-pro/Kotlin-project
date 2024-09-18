package com.practice.examples.collections

// Set operations
fun main() {
    // set operations
    // union()
    // Combine two collections into one and removes the duplicate
    println("Union()")
    val setA = setOf(1, 2, 3)
    val setB = setOf(3, 4, 5)
    val setUnion = setA union setB
    println(setUnion)

    // intersect()
    println("\nintersect()")
    val intersect = setA intersect setB
    println(intersect)

    // subtract
    println("\nsubtract()")
    val subtract = setA subtract setB
    println(subtract)
}