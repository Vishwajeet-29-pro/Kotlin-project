package com.practice.examples

// entry point in the Kotlin
// this is main fun and must outside of class
fun main() {
    println("Hello World")

    val a = 5
    val b = 3
    val max = if (a > b) a else b
    println("Maximum number is: $max")

    printPrimitiveDataTypes()
    printString()
//    nullSafety() // this one throws exception
    controlStructures(2, 5)
}

fun printPrimitiveDataTypes() {
    val num: Int = 5
    val name: String = "Vishwajeet"
    val floatingValue: Float = 4.2f
    val doubleValue: Double = 32.3
    val isKotlin: Boolean = true
    val char: Char = 'a'

    println("Integer datatype: $num")
    println("String :$name")
    println("Float: $floatingValue")
    println("Double: $doubleValue")
    println("Boolean: $isKotlin")
    println("Character: $char")
}

// Strings
// Declared using double quotes
// Strings are immutable
fun printString() {
    val greeting: String = "Hello World"
}

fun nullSafety() {
    // Use `?` to indicate a variable can hold Null value
    // Nullable type
    val name: String? = null

    // Safe call(?:)
    // used to specify access properties or methods of a nullable types
    val length = name?.length

    // Elvis Operator (?:)
    // Provides a default value if the expression on the left is `null`
    val nameLength = name?.length ?: 0

    println("Name: $name")
    println("Length: $length")
    println("Elvis: $nameLength")

    // Non-NUll Assertion (!!)
    // asserts that a value is non-null, throwing an exception if it is null
    val lengthOfName = name!!.length // throws NullPointerException if name is null

    println("Non null assertion: $lengthOfName")
}

fun controlStructures(a: Int, b: Int) {
    val max = if (a > b) a else b
    println("Max is $max")

    var min = 0
    min = if (a < b) a
    else if (a == b) a
    else b
    println("Min is $min")


    when (a) {
        1 -> println("a == 1")
        2 -> println("a == 2")
        else -> println("a is neither 1 nor 2")
    }

    for (i in 1..b) {
        println(i)
    }

    var c = 5
    while (c > 0) {
        println("C is now $c")
        c--
    }

    val range = 1..5
    for (i in range) {
        print(i)
    }
}