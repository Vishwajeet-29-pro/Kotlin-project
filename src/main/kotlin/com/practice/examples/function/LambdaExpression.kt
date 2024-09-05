package com.practice.examples.function

// Kotlin allows us to write even more concise code for functions by using lambda
// expressions.
// for example this upperCaseString() function
fun upperCaseString(text: String): String {
    return text.uppercase()
}

// Can be also written as a lambda expression:

fun main() {
    val upperCaseString = { text: String -> text.uppercase() }
    println(upperCaseString("hello"))

    println("Pass to another function")
    println("Positives: $positives")
    println("Negatives: $negatives")
}

/*
* Lambda expression can be hard to understand at first glance so let's break
* it down. Lambda expressions are written within curly braces {}.
*
* Within the lambda expression, you write:
* - The parameters followed by an ->.
* - The function body after the ->.
*
* Lambda expression can be used in a number of ways. You can:
* - Pass a lambda expression as a parameter to another function.
* - Return a lambda expression from a function
* - Invoke a lambda expression on its own
* */

// Pass to another function
/*
* A great example of when it is useful to pass a lambda expression to a function, is using
* the .filter() function on collections:
* */

val numbers  = listOf(1, -2, 3, -4, 5, -6)
val positives = numbers. filter({ x -> x > 0})

val isNegative = {x: Int -> x < 0}
val negatives = numbers.filter(isNegative)
