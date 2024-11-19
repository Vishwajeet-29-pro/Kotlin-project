package com.practice.examples

fun main() {
    var a: String = "abc"
    // a = null // Null can not be a value of a non-null type String
    println(a)
    // to assign null value to string use ?
    // This expression makes String a type that can accept null:
    var b: String? = "abc"
    b = null
    println(b)
    // if we directly try access length property on it gives you this error
    // Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
    // val length = b.length

    // to access the length of the b we need place the safe call (?.)
    val length = b?.length
}