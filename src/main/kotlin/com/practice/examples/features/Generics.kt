package com.practice.examples.features

/**
 * Classes in Kotlin have type parameters like Java
 *
 */
class Box<T>(t: T) {
    var value = t
}

// To create instance of a such class, simply provide type arguments:
val box: Box<Int> = Box<Int>(1)