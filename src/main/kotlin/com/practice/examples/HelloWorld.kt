package com.practice.examples

fun main() {
    println("Hello World")
    val output = printHello("Vishwajeet")
    println(output)
}

fun printHello(string: String): String {
    return "Hello $string"
}