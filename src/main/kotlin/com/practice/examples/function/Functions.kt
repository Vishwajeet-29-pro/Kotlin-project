package com.practice.examples.function

fun main() {
    // to call the function simply call the name of function followed by parenthesis.
    printHelloWorld() // as expected this will print 'Hello World' on new line.

    // here we pass two parameters i.e. two number and print the addition of numbers.
    addTwoNumbers(10, 20)

    // here call the function which takes the values and return the values.
    // for that we need to store result into some variable, or we can call the function inside of println() statement.
    val result = multiplyTwoNumbers(10.3, 20.32)
    println(result)
    // in println
    println(multiplyTwoNumbers(3923.3,123.21))

    // default argument function. In this function if we don't pass any value then it will take the default values
    // which set at the time of function creation, and currently we are not passing anything meaning it will take
    // default one.
    println("The result of default argument function is ${defaultArguments()}")
}

// to create a new function in kotlin use 'fun' keyword followed by name of the function and '()' parenthesis.
// Empty parenthesis means it's simple function which does not accept any parameters.
// this is simple function which print the message 'Hello World'.
fun printHelloWorld() {
    println("Hello World")
}

// here is another type of function i.e. function with parameters
// we can pass these parameters to fun as follows and then perform operations on these parameters.
// This function does not return anything, that's why by default it's return type is 'Unit'
fun addTwoNumbers(a: Int, b: Int) {
    val result = a + b
    println("The Addition of two numbers is: $result")
}

// here is next type in which we are going return the value from function with type.
// we explicitly define the return type here (we have different return type based on the operation in the function
// they are Int, Float, Char, String, etc. Also, 'Any' type from Kotlin, when we don't know type that time we can use it.)
fun multiplyTwoNumbers(a: Double, b: Double): Double {
    return a * b;
}

// default arguments function. In this function we set values for a and b at the time of creation of function.
// the syntax for setting default arguments is as follows.
fun defaultArguments(a: Int = 10, b: Int = 30): Int {
    return a + b
}