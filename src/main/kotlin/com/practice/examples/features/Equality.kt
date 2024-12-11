package com.practice.examples.features

/**
 * In Kotlin there are two types of equality:
 * 1. Structural Equality (==) - a check for equals() functions
 * 2. Referential Equality (===) - a check for two references pointing to the same object
 */
fun main() {

    /*
    Structural Equality verifies two objects have the same content or structure. Structural equality checked by
    the == operation and its negated part counterpart !=. By convention, an expression like a==b is translated to:
    `a?.equals(b) ?: (b === null)`
     */

    var a = "hello"
    var b = "hello"
    var c = null
    var d = null
    var e = d

    println(a==b)  // true
    println(a==c)  // false
    println(c==e)  // true

    /*
    Referential Equality verifies the memory addresses of two objects to determine if they are the same structure.
    Referential Equality is checked by === operation and its negated counterpart !==. `a === b` evaluates to true if and only
    if a and b point to the same object:
     */

    var p = "Hello"
    var q = p
    var r = "World"
    var s = "World"

    println(p === q) // true
    println(p === r) // false
    println(r === s) // true
}