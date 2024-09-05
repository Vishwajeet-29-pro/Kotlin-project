package com.practice.examples.function

fun main() {

    println(add(10,20))
    println(sum(10, 20))
}

// to make your code more concise we can use the single expression function.
// here is this function can be converted to single expression by simple means.
fun add(i: Int, j: Int): Int {
    return i + j
}

// We can remove the curly braces {} and declare the function body using the assignment
// operator =. When you use the assignment operator =, Kotlin uses type inference, so you can
// also omit the return type. The add() function then becomes one line:
// for conflict change name of the function.
fun sum(i: Int, j: Int) = i + j